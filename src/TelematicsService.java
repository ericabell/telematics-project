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
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f".
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);
                    System.out.println("Read from file: " + vi);
                } catch (FileNotFoundException ex) {
                    System.out.println("Could not find file *" + f + "*");
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        // update dashboard.html to show the data for all the VehicleInfo objects

        //
    }
}
