package Vehicles;

import java.text.DecimalFormat;

public class Car extends VehicleImpl {
    public Car(double fuelQuantity, double fuelConsumption,double tankCapacity) {

        super(fuelQuantity, fuelConsumption,tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double totalConsumption = distance * (super.fuelConsumption + 0.9);
        if (totalConsumption <= super.fuelQuantity) {
            super.fuelQuantity -= totalConsumption;
            String pattern = "0.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            String format = decimalFormat.format(distance);

            System.out.println(String.format("Car travelled %s km", format));
        }
        System.out.println("Car needs refueling");
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(liters);
    }

    @Override
    public void driveEmpty(double distance) {
        //implement logic if needed
    }
    @Override
    public String toString() {
        return String.format("Car: %.2f", this.fuelQuantity);
    }
}
