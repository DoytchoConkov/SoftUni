package bakery.entities.bakedFoods;

public class Cake extends BaseFood {
    private static final int InitialBreadPortion = 245;

    public Cake(String name,  double price) {
        super(name, InitialBreadPortion, price);
    }
}
