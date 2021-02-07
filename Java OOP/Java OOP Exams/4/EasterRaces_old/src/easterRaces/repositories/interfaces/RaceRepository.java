package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.RaceImpl;

import java.util.ArrayList;
import java.util.Collection;

public class RaceRepository implements Repository {
    private Collection<RaceImpl> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Object getByName(String name) {
        for (RaceImpl model : this.models) {
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
        this.models.add((RaceImpl) model);
    }

    @Override
    public boolean remove(Object model) {

        return this.models.remove(model);
    }
}
