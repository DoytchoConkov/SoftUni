package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar {
    public SportsCar(String model, int horsePower) {
        super(model, horsePower, 3000);
    }
}
