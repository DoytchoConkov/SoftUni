package Constructors;

public class Car {
    public String make;
    public String model;
    public int horsePower;


    public Car(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String make) {
        this.make = make;
        this.model = "unknown";
        this.horsePower = -1;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.make, this.model, this.horsePower);
    }
}
