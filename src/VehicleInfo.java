public class VehicleInfo {
    private int vehicleIdentificationNumber;
    private double odometer;
    private double gallonsOfGasConsumed;
    private double odometerAtLastOilChange;
    private double engineSizeInLiters;


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
}
