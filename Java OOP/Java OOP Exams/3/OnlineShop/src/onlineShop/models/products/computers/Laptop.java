package onlineShop.models.products.computers;

import onlineShop.models.products.BaseComputer;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.List;

public class Laptop extends BaseComputer {
    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, 10);
    }
}
