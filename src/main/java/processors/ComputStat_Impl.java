package processors;

import domain.PlatformSensorData;
import domain.PlatformStatResult;
import domain.PlatformStatResult_Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ComputStat_Impl {


    private ProcessBuilder_Impl processBuilder;

    public ComputStat_Impl(  ProcessBuilder_Impl processBuilder) {

        this.processBuilder = processBuilder;

    }

    public List<PlatformStatResult> computeStat( List<PlatformSensorData> data ) {



        // crete the return list object
        List<PlatformStatResult> returnResults = new ArrayList<>();

        Map<String,List<PlatformSensorData>>  platformDataMap;
        platformDataMap = data.stream()
            .collect(Collectors.groupingBy(PlatformSensorData::getName, ()-> new TreeMap<>(), Collectors.toList()));

        platformDataMap.forEach((name,platformData)-> {
            PlatformStatResult resultRow = new PlatformStatResult_Impl();
            resultRow.setName(name);
            returnResults.add(resultRow);
            processBuilder.getProcessors().forEach(p-> {
                p.processStats(resultRow, platformData);
            });
        });


        return returnResults;

    }


}
