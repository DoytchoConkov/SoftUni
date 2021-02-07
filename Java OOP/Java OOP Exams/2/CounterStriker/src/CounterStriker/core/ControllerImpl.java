package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();

    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        if (type.equals("Pistol")) {
            this.guns.add(new Pistol(name, bulletsCount));
        } else if (type.equals("Rifle")) {
            this.guns.add(new Rifle(name, bulletsCount));
        } else {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Object gun = this.guns.findByName(gunName);
        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        if (type.equals("Terrorist")) {

            this.players.add(new Terrorist(username, health, armor, (Gun) gun));
        } else if (type.equals("CounterTerrorist")) {
            this.players.add(new CounterTerrorist(username, health, armor, (Gun) gun));
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return this.field.start(this.players.getModels());
    }

    @Override
    public String report() {
        ArrayList<Player> models = new ArrayList<>(this.players.getModels());
        models=models.stream().sorted((p1, p2) -> {
            int compr = p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
            if (compr == 0) {
                compr = p2.getHealth() - p1.getHealth();
                if (compr == 0) {
                    compr = p1.getUsername().compareTo(p2.getUsername());
                }
            }
            return compr;
        }).collect(Collectors.toCollection(ArrayList::new));
        String result = "";
        for (Player model : models) {
            result += model.toString();
            result += System.lineSeparator();
        }
        return result.trim();
    }
}
