package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public class Work extends BaseProcedure {
    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot,procedureTime);
        robot.setHappiness(robot.getHappiness() + 12);
        robot.setEnergy(robot.getEnergy() - 6);
    }
}

