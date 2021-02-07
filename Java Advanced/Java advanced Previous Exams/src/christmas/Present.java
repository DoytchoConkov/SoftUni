package christmas;

public class Present {
    private String name;
    private double weigh;
    private String gender;

    public Present(String name, double weigh, String gender) {
        this.name = name;
        this.weigh = weigh;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weigh;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("Present %s (%.2f) for a %s", this.name, this.weigh, this.gender);
    }
}
