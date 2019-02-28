package processors;

import domain.PlatformSensorData;
import domain.PlatformStatResult;
import util.CsvReader_Impl;
import util.ModArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
/*
Min Gap Time:
Gap Time is the difference in receive time between two consecutive readings from the same platform. If there is only one reading for a platform the gap time is zero. This is the minimum gap time for a platform.

For Example:

Given this input:
ABCD,1000,2000,3,-90
ABCD,1500,3000,67,94
ABCD,1000,4000,42,907

You output for the platform ABCD for this field should be: 00:16:40
*/

public class MinimumGapStatProcessor_Impl extends IOTStatProcessor_Impl{
    public void processStats(PlatformStatResult resultToBeupdated, List<PlatformSensorData> platformSensorData){


        CsvReader_Impl test = new CsvReader_Impl();

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
        if(list.size() >0) {
            // take out the first item from the list
            list = list.subList(1, list.size());

            Optional<Long> value = list.stream().min(Comparator.comparing(Long::valueOf));
            resultToBeupdated.setMinGapTime(value.get());
        }else {
            resultToBeupdated.setMinGapTime(0);
        }

    }
}
