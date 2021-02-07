package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.RaceImpl;

import java.util.ArrayList;
import java.util.Collection;

public class DriverRepository implements Repository {
    private Collection<DriverImpl> models;

    public DriverRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Object getByName(String name) {
        for (DriverImpl model : this.models) {
            if (model.getName().equals(name)) {
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
        this.models.add((DriverImpl) model);
    }

    @Override
    public boolean remove(Object model) {

        return this.models.remove(model);
    }
}
