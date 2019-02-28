package processors;

/*Average Flight Time:
        Flight time is the difference between the send and receive time for a reading. This is the average of all flight times for a platform.

        For Example:

        Given this input:
        ABCD,1000,2000,3,-90
        ABCD,1500,3000,67,94
        ABCD,1000,4000,42,907

        You output for the platform ABCD for this field should be: 00:30:33*/

import domain.PlatformSensorData;
import domain.PlatformStatResult;

import java.util.List;
import java.util.stream.Collectors;

public class AverageFlightTimeStatProcessor_Impl extends IOTStatProcessor_Impl {
    public void processStats(PlatformStatResult resultToBeupdated, List<PlatformSensorData> platformSensorData) {

        // write the logic to compute the stat and update hte field correspondingly

        double avgFlightTime = platformSensorData.stream().collect(Collectors.averagingLong(data -> data.getFlightTime()));

        resultToBeupdated.setAvgFlightTime(Math.round(avgFlightTime));
    }

}
