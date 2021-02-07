package Vehicles1;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption) {

        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public String drive(double distance) {
        double totalConsumption = distance * (super.fuelConsumption + 0.9);
        if (totalConsumption <= super.fuelQuantity) {
            super.fuelQuantity -= totalConsumption;
            String pattern = "0.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            String format = decimalFormat.format(distance);

            return String.format("Car travelled %s km", format);
        }
        return "Car needs refueling";
    }

    @Override
    public void refill(double fuel) {
        super.fuelQuantity += fuel;
    }
}
