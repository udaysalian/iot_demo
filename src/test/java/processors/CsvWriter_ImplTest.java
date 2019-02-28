package processors;

import domain.PlatformStatResult;
import domain.PlatformStatResult_Impl;
import org.junit.jupiter.api.Test;
import util.CsvWriter_Impl;

import java.util.ArrayList;
import java.util.List;

class CsvWriter_ImplTest {

    @Test
    void writeCsvFile() {

        CsvWriter_Impl writer = new CsvWriter_Impl();
        List<PlatformStatResult> data = new ArrayList<PlatformStatResult>();
        PlatformStatResult output = new PlatformStatResult_Impl();
        output.setName("ABCD");
        output.setTotalGapTime(2000);
        output.setAvgFlightTime(1833);
        output.setMaxValue(907);
        output.setMinGapTime(1000);
        data.add(output);
        writer.writeCsvFile("output.csv",data);
    }

    @Test
    void convertEpocSecsToDate() {

    }
}