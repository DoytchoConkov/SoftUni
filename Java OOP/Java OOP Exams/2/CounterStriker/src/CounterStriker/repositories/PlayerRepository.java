package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository implements Repository {
    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection getModels() {
        return this.models;
    }

    @Override
    public void add(Object model) {
        if (model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        this.models.add((Player) model);
    }

    @Override
    public boolean remove(Object model) {

        return this.models.remove(model);
    }

    @Override
    public Player findByName(String name) {
        for (Player model : this.models) {
            if (model.getUsername().equals(name)) {
                return model;
            }
        }
        return null;
    }
}
