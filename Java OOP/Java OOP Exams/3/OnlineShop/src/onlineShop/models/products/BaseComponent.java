package onlineShop.models.products;

import onlineShop.models.products.components.Component;

public abstract class BaseComponent extends BaseProduct implements Component {
    private int generation;

    protected BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation=generation;
    }

    @Override
    public int getGeneration() {
        return generation;
    }

    @Override
    public String toString() {
        return super.toString()+" Generation: "+this.generation;
    }
}