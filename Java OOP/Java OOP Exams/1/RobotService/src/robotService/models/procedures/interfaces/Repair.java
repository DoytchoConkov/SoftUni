package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.ALREADY_REPAIRED;
import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public class Repair extends BaseProcedure {

    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot,procedureTime);
        robot.setHappiness(robot.getHappiness() - 5);
        if (robot.isRepaired()) {
            throw new IllegalArgumentException(String.format(ALREADY_REPAIRED, robot.getName()));
        }
        robot.setRepaired(true);
    }
}

