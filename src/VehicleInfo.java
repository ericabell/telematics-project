public class VehicleInfo {
    private int vehicleIdentificationNumber;
    private double odometer;
    private double gallonsOfGasConsumed;
    private double odometerAtLastOilChange;
    private double engineSizeInLiters;

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
