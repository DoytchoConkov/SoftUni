package PizzaCalories;

public enum DoughModifiersType {
    WHITE(1.5), WHOLEGRAIN(1.0);
    private double modifier;

    DoughModifiersType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
