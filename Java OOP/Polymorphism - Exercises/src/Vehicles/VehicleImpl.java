package Vehicles;

public abstract class VehicleImpl implements Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;

    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelConsumptionPerKm(double index) {
        this.fuelConsumption += index;
    }

    protected void setFuelQuantity(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        if (this.fuelQuantity + fuel > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += fuel;
        }
    }
}
