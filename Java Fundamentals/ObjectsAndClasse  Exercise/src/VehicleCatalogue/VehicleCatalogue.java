package VehicleCatalogue;

public class VehicleCatalogue {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public VehicleCatalogue(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void printVehicle(){
        System.out.println("Type: "+this.type);
        System.out.println("Model: "+this.model);
        System.out.println("Color: "+this.color);
        System.out.println("Horsepower: "+this.horsepower);
    }
}
