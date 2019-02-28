package processors;

import domain.PlatformSensorData;
import domain.PlatformStatResult;
import domain.PlatformStatResult_Impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.CsvReader_Impl;
import util.CsvWriter_Impl;

import java.util.List;

class AverageFlightTimeStatProcessor_ImplTest {

    @Test
    void processStats() {

        AverageFlightTimeStatProcessor_Impl avgFlighStatProc = new AverageFlightTimeStatProcessor_Impl();
        PlatformStatResult result = new PlatformStatResult_Impl();

        CsvReader_Impl test = new CsvReader_Impl();
        List<PlatformSensorData> platformSensorData = test.readDataFile("readFileTest.csv");

        avgFlighStatProc.processStats(result,platformSensorData );

        CsvWriter_Impl writer = new CsvWriter_Impl();
        String avgFlightTime = writer.convertEpocSecsToDate(result.getAvgFlightTime());

        Assertions.assertEquals( "00:30:33", avgFlightTime);
    }
}