package processors;

import domain.PlatformSensorData;
import domain.PlatformStatResult;

import java.util.List;

public interface IOTStatProcessor {

    public void processStats(PlatformStatResult resultToBeupdated, List<PlatformSensorData> platformSensorData);
}
