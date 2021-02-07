package Vehicles1;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }

    @Override
    public String drive(double distance) {
        double totalConsumption = distance * (super.fuelConsumption);
        if (totalConsumption <= super.fuelQuantity) {
            super.fuelQuantity -= totalConsumption;
            String pattern = "0.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            String format = decimalFormat.format(distance);

            return String.format("Truck travelled %s km", format);
        }
        return "Truck needs refueling";
    }

    @Override
    public void refill(double fuel) {
        super.fuelQuantity += fuel * 0.95;
    }
}
