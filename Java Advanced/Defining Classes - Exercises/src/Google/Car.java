package Google;

public class Car {
    private String model;
    private int speed;

    public Car() {
        this.model = "";
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }
}
