import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelematicsService {

    void report(VehicleInfo vehicleInfo) {
        // Write VehicleInfo to a file as JSON using the VIN number with json extension
        // the file will overwrite any previous file with the same VIN
        String filename = vehicleInfo.getVehicleIdentificationNumber() + ".json";
        File newFile = new File(filename);

        try {
            FileWriter fileWriter = new FileWriter(newFile);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // find all files that end with json and convert back to VehicleInfo objects
        File file = new File(".");

        // each file will be read into a new object and placed in this list
        ArrayList<VehicleInfo> vehicles = new ArrayList<>();

        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f".
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);
                    vehicles.add(vi);
                } catch (FileNotFoundException ex) {
                    System.out.println("Could not find file *" + f + "*");
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        // update dashboard.html to show the data for all the VehicleInfo objects

        // we will need to compute the averages for: odometer, consumptionOfGas,
        // lastOilChange, and engineSize
        Double totalOdometer = 0.0;
        Double totalGallonsOfGasConsumed = 0.0;
        Double totalOdometerAtLastOilChange = 0.0;
        Double totalEngineSize = 0.0;

        Double averageOdometer = 0.0;
        Double averageGallonsOfGasConsumed = 0.0;
        Double averageOdometerAtLastOilChange = 0.0;
        Double averageEngineSize = 0.0;

        for( VehicleInfo vehicle: vehicles ) {
            totalOdometer += vehicleInfo.getOdometer();
            totalGallonsOfGasConsumed += vehicleInfo.getGallonsOfGasConsumed();
            totalOdometerAtLastOilChange += vehicleInfo.getOdometerAtLastOilChange();
            totalEngineSize += vehicleInfo.getEngineSizeInLiters();
        }

        averageOdometer = totalOdometer / vehicles.size();
        averageGallonsOfGasConsumed = totalGallonsOfGasConsumed / vehicles.size();
        averageOdometerAtLastOilChange = totalOdometerAtLastOilChange / vehicles.size();
        averageEngineSize = totalEngineSize / vehicles.size();

        // Read in index.template to a String
        file = new File ("index.template");
        String fileContents = new String();
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                fileContents += fileScanner.nextLine() + "\n";
            }
        } //Since this time we are asking for data back from the file
        //We have to specify what to do if it isn't found
        catch (FileNotFoundException ex) {
            System.out.println("Could not find file *" + file + "*");
            ex.printStackTrace();
        }

        // Replace Averages with numbers
        fileContents = fileContents.replace("aveOdometer", averageOdometer.toString());
        fileContents = fileContents.replace("aveConsumption", averageGallonsOfGasConsumed.toString());
        fileContents = fileContents.replace("aveLastOilChange", averageOdometerAtLastOilChange.toString());
        fileContents = fileContents.replace("aveEngineSize", averageEngineSize.toString());

        // write the new file
        filename = "index.html";
        newFile = new File(filename);

        try {
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(fileContents);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
