package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    public PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        this.setAlive(true);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().equals("")) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (points < this.getArmor()) {
            this.setArmor(this.armor - points);
        } else {
            points = this.getHealth() - points + this.getArmor();
            if (points > 0) {
                this.setHealth(points);
                this.setArmor(0);
            } else {
                this.setHealth(points);
                this.setArmor(0);
                this.setAlive(false);
            }
        }
    }

    @Override
    public String toString() {
        String result = String.format( this.getClass().getSimpleName() + ": " + this.getUsername() + "\n" +
                "--Health: " + this.getHealth() + "\n" +
                "--Armor: " + this.getArmor() + "\n" +
                "--Gun: " + this.getGun().getName());
        return result;
    }
}
