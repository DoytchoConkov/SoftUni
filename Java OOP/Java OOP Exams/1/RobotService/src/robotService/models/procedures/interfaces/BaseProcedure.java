package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public abstract class BaseProcedure implements Procedure {

    protected Collection<Robot> robots;

    protected BaseProcedure() {
        this.robots = new ArrayList<>();
    }

    @Override
    public String history() {
        StringBuilder result = new StringBuilder(String.format("%s%n", this.getClass().getSimpleName()));
        for (Robot robot : robots) {
            result.append(robot.toString());
            result.append(System.lineSeparator());
        }
        return result.toString().trim();
    }

    @Override
    public void doService(Robot robot, int procedureTime){
        if (robot.getProcedureTime() <= procedureTime) {
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }
        robot.setProcedureTime(robot.getProcedureTime()-procedureTime);
        this.robots.add(robot);
    }
}
