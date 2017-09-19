import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // use Scanner to get VehicleInfo from the user
        // and initialize the POJO

        Scanner scanner = new Scanner(System.in);

        VehicleInfo newVehicle = new VehicleInfo();

        System.out.println("Please enter the following info about your vehicle.");

        System.out.println("VIN:");
        newVehicle.setVehicleIdentificationNumber(Integer.parseInt(scanner.nextLine()));

        System.out.println("Odometer:");
        newVehicle.setOdometer(Double.parseDouble(scanner.nextLine()));

        System.out.println("Gallons of gas consumed:");
        newVehicle.setGallonsOfGasConsumed(Double.parseDouble(scanner.nextLine()));

        System.out.println("Odometer at last oil change:");
        newVehicle.setOdometerAtLastOilChange(Double.parseDouble(scanner.nextLine()));

        System.out.println("Engine size in liters:");
        newVehicle.setEngineSizeInLiters(Double.parseDouble(scanner.nextLine()));

        // call the report method from TelematicsService and pass
        // the VehicleInfo POJO

        TelematicsService telematicsService = new TelematicsService();
        telematicsService.report(newVehicle);

    }
}
