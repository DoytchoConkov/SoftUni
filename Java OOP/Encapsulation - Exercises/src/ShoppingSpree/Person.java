package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }


    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            System.out.printf("%s can't afford %s%n", this.getName(), product.getName());
        } else {
            this.setMoney(this.money - product.getCost());
            this.products.add(product);
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        }
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return this.name + " - Nothing bought";
        }
        return this.name +
                " - " +
                this.products
                        .stream()
                        .map(Product::toString)
                        .collect(Collectors.joining(", "));
    }
}
