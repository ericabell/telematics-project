import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VehicleInfo {
    private int vehicleIdentificationNumber;
    private double odometer;
    private double gallonsOfGasConsumed;
    private double odometerAtLastOilChange;
    private double engineSizeInLiters;

    private Date dateOfService;


    // EXTRAS: add getMilesPerGallon method (only method, not a variable)
    // and use it to update the dashboard with MPG info

    // MORE EXTRAS: add a timestamp LocalDateTime to the VehicleInfo. Set it in the
    // report method. show it in the html in a nice human-readable format.

    public VehicleInfo() {
    }

    public int getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(int vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getGallonsOfGasConsumed() {
        return gallonsOfGasConsumed;
    }

    public void setGallonsOfGasConsumed(double gallonsOfGasConsumed) {
        this.gallonsOfGasConsumed = gallonsOfGasConsumed;
    }

    public double getOdometerAtLastOilChange() {
        return odometerAtLastOilChange;
    }

    public void setOdometerAtLastOilChange(double odometerAtLastOilChange) {
        this.odometerAtLastOilChange = odometerAtLastOilChange;
    }

    public double getEngineSizeInLiters() {
        return engineSizeInLiters;
    }

    public void setEngineSizeInLiters(double engineSizeInLiters) {
        this.engineSizeInLiters = engineSizeInLiters;
    }

    public Date getDateOfService() {
        return dateOfService;
    }

    public void setDateOfService(Date dateOfService) {
        this.dateOfService = dateOfService;
    }

    public String niceDateOfService() {
        DateFormat dateTimeInstance = new SimpleDateFormat("mm/dd/yyyy HH:mm:ss");
        return dateTimeInstance.format(dateOfService);
    }

    public Double calculateMilesPerGallon() {
        return odometer / gallonsOfGasConsumed;
    }

    /*@Override
    public String toString() {
        return "VehicleInfo{" +
                "vehicleIdentificationNumber=" + vehicleIdentificationNumber +
                ", odometer=" + odometer +
                ", gallonsOfGasConsumed=" + gallonsOfGasConsumed +
                ", odometerAtLastOilChange=" + odometerAtLastOilChange +
                ", engineSizeInLiters=" + engineSizeInLiters +
                '}';
    }*/
}
