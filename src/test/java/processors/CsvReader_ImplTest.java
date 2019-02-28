package processors;

import domain.PlatformSensorData;
import org.junit.jupiter.api.Assertions;
import util.CsvReader_Impl;

import java.util.List;

class CsvReader_ImplTest {

    @org.junit.jupiter.api.Test
    void readDataFile() {

        CsvReader_Impl test = new CsvReader_Impl();
        List<PlatformSensorData> platformSensorData = test.readDataFile("readFileTest.csv");

        Assertions.assertEquals(3, platformSensorData.size());
        PlatformSensorData firstRow = platformSensorData.get(0);
        Assertions.assertEquals("ABCD", firstRow.getName());
        Assertions.assertEquals(1000, firstRow.getReadSendTime());
        Assertions.assertEquals(2000, firstRow.getReadReceiveTime());
        Assertions.assertEquals(3, firstRow.getNumberOfSensors());
        Assertions.assertEquals( -90, firstRow.getValue());


    }
}