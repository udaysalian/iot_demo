package util;

import domain.PlatformStatResult;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter_Impl {


    public CsvWriter_Impl( ) {


    }
    public void writeCsvFile(String outputFile, List<PlatformStatResult> outputData) {

        String fileName = "src/main/resources/" + outputFile;
        String separator = ",";
        FileWriter statOutputFileWriter = null;

        try {
            statOutputFileWriter = new FileWriter(fileName);


            //Write a new student object list to the CSV file
            for (PlatformStatResult statResult : outputData) {
                statOutputFileWriter.append(String.valueOf(statResult.getName()));
                statOutputFileWriter.append(separator);

                statOutputFileWriter.append(convertEpocSecsToDate (statResult.getTotalGapTime()));
                statOutputFileWriter.append(separator);
                statOutputFileWriter.append(convertEpocSecsToDate(statResult.getAvgFlightTime()));

                statOutputFileWriter.append(separator);
                statOutputFileWriter.append(String.valueOf(statResult.getMaxValue()));

                statOutputFileWriter.append(separator);
                statOutputFileWriter.append(convertEpocSecsToDate(statResult.getMinGapTime()));
                statOutputFileWriter.append("\n");

            }


            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                statOutputFileWriter.flush();
                statOutputFileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public String convertEpocSecsToDate(long time) {

        return EpochUtil.convertEpocSecsToDate(time);

      /*  Date date = new Date(time * 1000); // multiply by 1000 for seconds
        SimpleDateFormat format = new SimpleDateFormat("00:mm:ss", Locale.US);
        String text = format.format(date);
        return text;*/

    }

}
