package Traffic_Lights;

public enum TrafficLights {
    RED("GREEN"),GREEN("YELLOW"),YELLOW("RED");
    private String color;


    TrafficLights(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
