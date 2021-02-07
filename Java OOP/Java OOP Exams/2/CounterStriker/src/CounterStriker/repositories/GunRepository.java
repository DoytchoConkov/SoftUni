package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class GunRepository implements Repository {
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection getModels() {
        return this.models;
    }

    @Override
    public void add(Object model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        this.models.add((Gun) model);
    }

    @Override
    public boolean remove(Object model) {
        return this.models.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        for (Gun model : this.models) {
            if (model.getName().equals(name)){
                return model;
            }
        }
       return null;
    }
}
