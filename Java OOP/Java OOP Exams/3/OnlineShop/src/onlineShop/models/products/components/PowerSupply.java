package onlineShop.models.products.components;

import onlineShop.models.products.BaseComponent;

public class PowerSupply extends BaseComponent  {
    public PowerSupply(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * 1.05, generation);
    }

}
