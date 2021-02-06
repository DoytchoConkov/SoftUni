package RawData;

public class CargoCar {

    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;
    private double tirePressure1;
    private int tireAge1;
    private double tirePressure2;
    private int tireAge2;
    private double tirePressure3;
    private int tireAge3;
    private double tirePressure4;
    private int tireAge4;

    public CargoCar(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
                    double tirePressure1, int tireAge1, double tirePressure2, int tireAge2,
                    double tirePressure3, int tireAge3, double tirePressure4, int tireAge4) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tirePressure1 = tirePressure1;
        this.tireAge1 = tireAge1;
        this.tirePressure2 = tirePressure2;
        this.tireAge2 = tireAge2;
        this.tirePressure3 = tirePressure3;
        this.tireAge3 = tireAge3;
        this.tirePressure4 = tirePressure4;
        this.tireAge4 = tireAge4;
    }

    public String getModel() {
        return model;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public double getTirePressure1() {
        return tirePressure1;
    }

    public int getTireAge1() {
        return tireAge1;
    }

    public double getTirePressure2() {
        return tirePressure2;
    }

    public int getTireAge2() {
        return tireAge2;
    }

    public double getTirePressure3() {
        return tirePressure3;
    }

    public int getTireAge3() {
        return tireAge3;
    }

    public double getTirePressure4() {
        return tirePressure4;
    }

    public int getTireAge4() {
        return tireAge4;
    }
}
