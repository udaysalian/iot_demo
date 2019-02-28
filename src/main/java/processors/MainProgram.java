package processors;

import domain.PlatformSensorData;
import domain.PlatformStatResult;
import util.CsvReader_Impl;
import util.CsvWriter_Impl;

import java.util.List;

public class MainProgram {

    private String inputFile; //data file
    private String outputFile; // output file

    public static void main(String[] args) {

        MainProgram computEngine = new MainProgram();
        computEngine.setInputFile("input.txt");
        computEngine.setOutputFile("output.csv");

        computEngine.doIt();

    }

    public void setInputFile(String fileName) {
        inputFile = fileName;
    }
    public void setOutputFile(String fileName) {
        outputFile = fileName;
    }

    public List<PlatformSensorData> getInputData() {
        CsvReader_Impl reader = new CsvReader_Impl();
        return reader.readDataFile(inputFile);
    }

    public void writeOutputFile(List<PlatformStatResult> results) {
        CsvWriter_Impl writer = new CsvWriter_Impl();
        writer.writeCsvFile(outputFile,results);
    }

    public void doIt() {
        ComputStat_Impl computStat = new ComputStat_Impl(getProcessBuilder());

        // write output from the compute stst
        writeOutputFile(computStat.computeStat(getInputData()));
    }

    public ProcessBuilder_Impl getProcessBuilder() {
       ProcessBuilder_Impl processbuilder = new ProcessBuilder_Impl(new AverageFlightTimeStatProcessor_Impl(),
                new MaxValueStatProcessor_Impl(),
                new MinimumGapStatProcessor_Impl(),
                new TotalGapTimeStatProcessor_Impl());
       return processbuilder;
    }

}
