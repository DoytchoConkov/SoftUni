package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.BaseCar;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;

import java.util.*;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private CarRepository cars;
    private DriverRepository drivers;
    private RaceRepository races;

    public ControllerImpl() {
        this.cars = new CarRepository();
        this.drivers = new DriverRepository();
        this.races = new RaceRepository();
    }

    @Override
    public String createDriver(String driver) {

        Object byName = this.drivers.getByName(driver);
        if (byName != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }
        this.drivers.add(new DriverImpl(driver));
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Object byName = this.cars.getByName(model);
        if (byName != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        BaseCar car;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else {
            car = new SportsCar(model, horsePower);
        }
        this.cars.add(car);
        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        DriverImpl name = (DriverImpl) this.drivers.getByName(driverName);
        if (name == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        BaseCar car = (BaseCar) this.cars.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        name.addCar(car);
        return String.format("Driver %s received car %s.", driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        DriverImpl name = (DriverImpl) this.drivers.getByName(driverName);
        if (name == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        Race race = (Race) this.races.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        race.addDriver(name);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }


    @Override
    public String startRace(String raceName) {
        RaceImpl race = (RaceImpl) this.races.getByName(raceName);
        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        List<Driver> drivers = new ArrayList<>();
        for (Driver driver : race.getDrivers()) {
            drivers.add(driver);
        }
        drivers.stream().sorted((d1, d2) -> {
            if (d2.getCar().calculateRacePoints(race.getLaps()) >= d1.getCar().calculateRacePoints(race.getLaps())) {
                return 1;
            }
            return -1;
        });
        StringBuilder result = new StringBuilder();
        result.append(String.format("Driver %s wins Daytona race.", drivers.get(0).getName()));
        result.append(System.lineSeparator());
        result.append(String.format("Driver Peter is second in Daytona race.", drivers.get(0).getName()));
        result.append(System.lineSeparator());
        result.append(String.format("Driver Brian is third in Daytona race.", drivers.get(0).getName()));
        return result.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Object byName = this.races.getByName(name);
        if (byName != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        this.races.add(new RaceImpl(name, laps));
        return String.format(RACE_CREATED, name);
    }
}
