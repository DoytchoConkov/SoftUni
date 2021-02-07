package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int toppingsCnt;

    public Pizza(String name, int toppingsCnt) {
        setName(name);
        setToppings(toppingsCnt);
        this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int toppingsCnt) {
        if (toppingsCnt < 0 || toppingsCnt > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingsCnt = toppingsCnt;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping toppping) {
        this.toppings.add(toppping);
    }

    public double getOverallCalories() {
        double result = this.dough.calculateCalories();
        for (Topping topping : this.toppings) {
            result += topping.calculateCalories();
        }
        return result;
    }

}
