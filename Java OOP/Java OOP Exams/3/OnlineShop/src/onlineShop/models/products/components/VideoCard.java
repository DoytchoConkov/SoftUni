package onlineShop.models.products.components;

import onlineShop.models.products.BaseComponent;

public class VideoCard extends BaseComponent {
    public VideoCard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * 1.15, generation);
    }
}
