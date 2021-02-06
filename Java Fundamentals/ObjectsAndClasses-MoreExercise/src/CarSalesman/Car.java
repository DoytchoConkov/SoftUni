package CarSalesman;

public class Car {

    private String model;
    private String engine;
    private String weight;
    private String color;

    public Car(String model, String engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String  toString(Engine engine){
        String result=String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%n" +
                "Efficiency: %s%nWeight: %s%nColor: %s",this.model,this.engine,engine.getPower(),
                engine.getDisplacement(),engine.getEfficiency(),this.weight,this.color);
        return result;
    }
}
