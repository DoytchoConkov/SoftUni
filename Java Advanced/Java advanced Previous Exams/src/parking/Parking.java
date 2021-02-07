package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manifacturer, String model) {
        boolean isThere = false;
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manifacturer) && car.getModel().equals(model)) {
                isThere = true;
                this.data.remove(car);
                break;
            }
        }
        return isThere;
    }

    public Car getLatestCar() {
        int latestYear = Integer.MIN_VALUE;
        Car latestCar = null;
        for (Car car : this.data) {
            if (car.getYear() > latestYear) {
                latestYear = car.getYear();
                latestCar = car;
            }
        }
        return latestCar;
    }

    public Car getCar(String manifacturer, String model) {
        Car searchedCar = null;
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manifacturer) && car.getModel().equals(model))
                searchedCar = car;
        }
        return searchedCar;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        String result = String.format("The cars are parked in %s:%n", this.type);
        for (Car car : this.data) {
            result += car.getManufacturer() + " " + car.getModel()+"\n";
        }
        return result;
    }
}
