package robotService.models.robots.interfaces;

import static robotService.common.ExceptionMessages.INVALID_HAPPINESS;

public class Cleaner extends BaseRobot {
    public Cleaner(String name, int happiness, int energy, int procedureTime) {
        super(name, energy, happiness, procedureTime);
    }
}
