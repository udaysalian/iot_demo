package processors;

import domain.PlatformSensorData;
import domain.PlatformStatResult;
import domain.PlatformStatResult_Impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.CsvReader_Impl;

import java.util.List;

class MaxValueStatProcessor_ImplTest {

    @Test
    void processStats() {

        MaxValueStatProcessor_Impl maxValueStatProcessor = new MaxValueStatProcessor_Impl();
        PlatformStatResult result = new PlatformStatResult_Impl();

        CsvReader_Impl test = new CsvReader_Impl();
        List<PlatformSensorData> platformSensorData = test.readDataFile("readFileTest.csv");

        maxValueStatProcessor.processStats(result,platformSensorData );

        Assertions.assertEquals( 907, result.getMaxValue());
    }


}