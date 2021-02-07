package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {

    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.capacity - this.data.size() > 0) {
            this.data.add(pet);
        }
    }

    public boolean remove(String petName) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(petName)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String petName, String ownerName) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(petName) && pet.getOwner().equals(ownerName)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        int oldest = Integer.MIN_VALUE;
        Pet oldestPet = null;
        for (Pet currentPet : this.data) {
            if (currentPet.getAge() > oldest) {
                oldest = currentPet.getAge();
                oldestPet = currentPet;
            }
        }
        return oldestPet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        String result = "The clinic has the following patients:\n";
        for (Pet pet : this.data) {
            result = result + pet.getName() + " " + pet.getOwner() + "\n";
        }
        return result;
    }
}
