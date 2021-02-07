package easterRaces.entities.racers;

import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static easterRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("") || name.length() < 5) {
            throw new Error(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < 1) {
            throw new Error(String.format(INVALID_NUMBER_OF_LAPS, 1));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException (String.format(DRIVER_INVALID));
        } else if (driver.getCar() == null) {
            throw new IllegalArgumentException (String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));
        } else if (this.drivers.contains(driver)) {
            throw new IllegalArgumentException (String.format(DRIVER_ALREADY_ADDED, driver.getName(), this.getName()));
        }
        this.drivers.add(driver);
    }

}
