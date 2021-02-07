package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.BaseCar;
import easterRaces.entities.racers.RaceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CarRepository implements Repository {
    private Collection<BaseCar> models;

    public CarRepository() {

        this.models = new ArrayList<>();
    }


    @Override

    public Object getByName(String name) {
        for (BaseCar model : this.models) {
            if (model.getModel().equals(name)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection getAll() {

        return this.models;
    }

    @Override
    public void add(Object model) {
        this.models.add((BaseCar) model);
    }

    @Override
    public boolean remove(Object model) {

        return this.models.remove(model);
    }
}
