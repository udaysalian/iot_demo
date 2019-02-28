package processors;

/*


Max Value:
        This is the maximum reading from all sensors on a platform.

        For Example:

        Given this input:
        ABCD,1000,2000,3,-90
        ABCD,1500,3000,67,94
        ABCD,1000,4000,42,907

        You output for the platform ABCD for this field should be: 907
*/

import domain.PlatformSensorData;
import domain.PlatformStatResult;

import java.util.List;
import java.util.NoSuchElementException;

public class MaxValueStatProcessor_Impl extends IOTStatProcessor_Impl {
    public void processStats(PlatformStatResult resultToBeupdated, List<PlatformSensorData> platformSensorData){

        // write the logic to compute the stat and update the field correspondingly


            Integer maxValue = platformSensorData
                    .stream()
                    .mapToInt(data->data.getValue())
                    .max().orElseThrow(NoSuchElementException::new);

            resultToBeupdated.setMaxValue(maxValue);

    }
}
