package HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> products;
    private String name;

    public Salad(String name) {
        this.products = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getTotalCalories() {
        int totalCalorie = 0;
        for (Vegetable product : this.products) {
            totalCalorie += product.getCalories();
        }
        return totalCalorie;
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        String result = String.format("* Salad %s is %d calories and have %d products:", this.name, this.getTotalCalories(), this.getProductCount());
        for (Vegetable product : this.products) {
            result += "\n"+ product.toString() ;
        }
        return result;
    }
}
