package processors;

/*Total Gap Time:
        Gap Time is the difference in receive time between two consecutive readings from the same platform. If there is only one reading for a platform the gap time is zero. This is the sum total of all gap times for a platform.

        For Example:

        Given this input:
        ABCD,1000,2000,3,-90
        ABCD,1500,3000,67,94
        ABCD,1000,4000,42,907

        You output for the platform ABCD for this field should be: 00:33:20*/

import domain.PlatformSensorData;
import domain.PlatformStatResult;
import util.ModArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class TotalGapTimeStatProcessor_Impl extends IOTStatProcessor_Impl{
    public void processStats(PlatformStatResult resultToBeupdated, List<PlatformSensorData> platformSensorData){

        /*
        *
        * The total gap can be also computed by taking the last row and first row
        * provided the list ordered by the epoch time
        * *
        * *Method 1
         *
        long totalGap = platformSensorData.get(platformSensorData.size()-1).getReadReceiveTime() - platformSensorData.get(0).getReadReceiveTime();
        resultToBeupdated.setTotalGapTime(totalGap);
        */


        /*
         *
         * The total gap can be also computed by taking the last row and first row
         * provided the list ordered by the epoch time
         * *
         * *Method 2
         */
        // List<Long> gapList = platformSensorData.stream().mapToLong(data->data.getReadReceiveTime()).
        long firstValue = platformSensorData.get(0).getReadReceiveTime();
        List<Long> list = platformSensorData.stream()
                .collect(
                        () -> new ModArrayList(firstValue),// Creating the container
                        (l, i) -> {
                            long number = i.getReadReceiveTime() - l.getPreviousValue();
                            l.add(number);
                            l.setPreviousValue(i.getReadReceiveTime());
                        }
                        , // Adding an element
                        (l1, l2) -> l1.addAll(l2) // Combining elements

                );
        resultToBeupdated.setTotalGapTime(list.stream().collect(Collectors.summingLong(data->data.longValue())));

    }
}
