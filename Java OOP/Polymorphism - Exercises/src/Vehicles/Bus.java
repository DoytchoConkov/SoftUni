package Vehicles;

import java.text.DecimalFormat;

public class Bus extends VehicleImpl {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double totalConsumption = distance * (this.fuelConsumption + 1.4);
        System.out.println(isEnoughtFuel(distance, totalConsumption));
    }

    @Override
    public void refuel(double liters) {
        setFuelQuantity(liters);
    }

    public void driveEmpty(double distance) {
        System.out.println(isEnoughtFuel(distance, this.fuelConsumption*distance));
    }

    private String isEnoughtFuel(double distance, double totalConsumption) {
        if (totalConsumption <= this.fuelQuantity) {
            this.fuelQuantity -= totalConsumption;
            String pattern = "0.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            String format = decimalFormat.format(distance);

            return String.format("Bus travelled %s km", format);
        }
        return "Bus needs refueling";
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", this.fuelQuantity);
    }

}
