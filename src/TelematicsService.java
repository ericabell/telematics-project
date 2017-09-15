import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
                // You can use this to create a new instance of Scanner
            }
        }

        // update dashboard.html to show the data for all the VehicleInfo objects

        //
    }
}
