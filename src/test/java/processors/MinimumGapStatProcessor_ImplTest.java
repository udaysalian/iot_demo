package processors;

import domain.PlatformSensorData;
import domain.PlatformStatResult;
import domain.PlatformStatResult_Impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.CsvReader_Impl;
import util.CsvWriter_Impl;

import java.util.List;

class MinimumGapStatProcessor_ImplTest {

    @Test
    void processStats() {

        IOTStatProcessor minimumGapStatProcessor = new MinimumGapStatProcessor_Impl();
        PlatformStatResult result = new PlatformStatResult_Impl();

        CsvReader_Impl test = new CsvReader_Impl();
        List<PlatformSensorData> platformSensorData = test.readDataFile("readFileTest.csv");

        minimumGapStatProcessor.processStats(result,platformSensorData );

        CsvWriter_Impl writer = new CsvWriter_Impl();
        String minGapTimeString = writer.convertEpocSecsToDate(result.getMinGapTime());

        Assertions.assertEquals( "00:16:40", minGapTimeString);
    }
}