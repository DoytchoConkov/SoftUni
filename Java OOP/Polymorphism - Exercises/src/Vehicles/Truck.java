package Vehicles;

import java.text.DecimalFormat;

public class Truck extends VehicleImpl {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double totalConsumption = distance * (super.fuelConsumption);
        if (totalConsumption <= super.fuelQuantity) {
            super.fuelQuantity -= totalConsumption;
            String pattern = "0.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            String format = decimalFormat.format(distance);

            System.out.println(String.format("Truck travelled %s km", format));
        }
        System.out.println("Truck needs refueling");
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(liters * 0.95);
    }

    @Override
    public void driveEmpty(double distance) {
        //implement logic if needed
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.fuelQuantity);
    }
}