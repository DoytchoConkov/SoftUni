package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;
    private double toppingModifier;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingModifier = ToppingModifieres.valueOf(toppingType.toUpperCase()).getModifier();
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.%n", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].%n", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return this.weight * 2 * ToppingModifieres.valueOf(this.toppingType.toUpperCase()).getModifier();
    }
}
