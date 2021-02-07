package Vehicles1;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected  double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    protected abstract String drive(double distance);
   protected abstract void refill(double fuel);
}
