package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private List<Rabbit> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


    public boolean removeRabbit(String name) {
        boolean isExist = false;
        for (Rabbit rabit : this.data) {
            if (rabit.getName().equals(name)) {
                isExist = true;
                this.data.remove(rabit);
                break;
            }
        }
        return isExist;
    }

    public void removeSpecies(String species) {
        List<Rabbit> rabbitsToRemove = new ArrayList<>();
        for (Rabbit rabit : this.data) {
            if (rabit.getName().equals(name)) {
                rabbitsToRemove.add(rabit);
            }
        }
        rabbitsToRemove.forEach(e -> this.data.remove(e));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (Rabbit rab : this.data) {
            if (rab.getName().equals(name)) {
                rab.setAvailable(false);
                return rab;
            }
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbits = new ArrayList<>();
        for (Rabbit rab : this.data) {
            if (rab.getSpecies().equals(species)) {
                rab.setAvailable(false);
                rabbits.add(rab);
            }
        }
        return rabbits;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        String result = String.format("Rabbits available at %s:%n", this.name);
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()) {
                result += rabbit + "\n";
            }
        }

        return result;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

}
