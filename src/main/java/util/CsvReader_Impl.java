package util;

import domain.PlatformSensorData;
import domain.PlatformSensorData_Impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader_Impl {
    public CsvReader_Impl() {
    }

    public List<PlatformSensorData> readDataFile(String dataFile) {


        String fileName = "src/main/resources/" + dataFile;
        BufferedReader dataRowReader = null;
        String line = "";
        String separator = ",";
        List<PlatformSensorData> returnList = new ArrayList<PlatformSensorData>() ;

        try

        {

            dataRowReader = new BufferedReader(new FileReader(fileName));
            while ((line = dataRowReader.readLine()) != null) {

                // use comma as separator
                String[] platformData = line.split(separator);

                // create platform data
                PlatformSensorData data = new PlatformSensorData_Impl();
                data.setName(platformData[0]);
                data.setReadSendTime(Long.valueOf(platformData[1]));
                data.setReadReceiveTime(Long.valueOf(platformData[2]));
                data.setNumberOfSensors(Integer.valueOf(platformData[3]));
                data.setValue(Integer.valueOf(platformData[4]));

                // add to the list of data
                returnList.add(data);



            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataRowReader != null) {
                try {
                    dataRowReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return returnList;

    }




}

