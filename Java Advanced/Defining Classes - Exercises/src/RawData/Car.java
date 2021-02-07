package RawData;

public class Car {
    private String model;
    private  int speed;
    private int power;
    private  int weight;
    private String type;
    private double tire1Preasure;
    private int tire1Age;
    private double tire2Preasure;
    private int tire2Age;
    private double tire3Preasure;
    private int tire3Age;
    private double tire4Preasure;
    private int tire4Age;

    public Car(String model, int speed, int power, int weight, String type, double tire1Preasure, int tire1Age, double tire2Preasure, int tire2Age, double tire3Preasure, int tire3Age, double tire4Preasure, int tire4Age) {
        this.model = model;
        this.speed = speed;
        this.power = power;
        this.weight = weight;
        this.type = type;
        this.tire1Preasure = tire1Preasure;
        this.tire1Age = tire1Age;
        this.tire2Preasure = tire2Preasure;
        this.tire2Age = tire2Age;
        this.tire3Preasure = tire3Preasure;
        this.tire3Age = tire3Age;
        this.tire4Preasure = tire4Preasure;
        this.tire4Age = tire4Age;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPower() {
        return power;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public double getTire1Preasure() {
        return tire1Preasure;
    }

    public int getTire1Age() {
        return tire1Age;
    }

    public double getTire2Pressure() {
        return tire2Preasure;
    }

    public int getTire2Age() {
        return tire2Age;
    }

    public double getTire3Pressure() {
        return tire3Preasure;
    }

    public int getTire3Age() {
        return tire3Age;
    }

    public double getTire4Pressure() {
        return tire4Preasure;
    }

    public int getTire4Age() {
        return tire4Age;
    }
}
