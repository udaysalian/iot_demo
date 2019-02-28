package processors;

import domain.PlatformSensorData;
import domain.PlatformStatResult;
import domain.PlatformStatResult_Impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.CsvReader_Impl;
import util.CsvWriter_Impl;

import java.util.List;

class TotalGapTimeStatProcessor_ImplTest {

    @Test
    void processStats() {

        IOTStatProcessor totalGapTimeStatProcessor = new TotalGapTimeStatProcessor_Impl();
        PlatformStatResult result = new PlatformStatResult_Impl();

        CsvReader_Impl test = new CsvReader_Impl();
        List<PlatformSensorData> platformSensorData = test.readDataFile("readFileTest.csv");

        totalGapTimeStatProcessor.processStats(result,platformSensorData );

        CsvWriter_Impl writer = new CsvWriter_Impl();
        String totalGapTimeString = writer.convertEpocSecsToDate(result.getTotalGapTime());

        Assertions.assertEquals( "00:33:20", totalGapTimeString);
    }
}