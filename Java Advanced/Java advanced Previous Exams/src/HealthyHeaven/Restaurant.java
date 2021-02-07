package HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant(String name) {
        this.data = new ArrayList<>();
        this.name = name;
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        boolean isExist = false;
        for (Salad salad : this.data) {
            if (salad.getName().equals(name)) {
                isExist = true;
                this.data.remove(salad);
                break;
            }
        }
        return isExist;
    }

    public String getHealthiestSalad() {
        String currentSalad = "";
        int minCalories = Integer.MAX_VALUE;
        for (Salad salad : this.data) {
            if (salad.getTotalCalories() < minCalories) {
                minCalories = salad.getTotalCalories();
                currentSalad = salad.getName();
            }
        }
        return currentSalad;
    }

    public String generateMenu() {
        String result = String.format("%s have %d salads:", this.name, this.data.size());
        for (Salad salad : this.data) {
            result += "\n" + salad;
        }
        return result;
    }
}
