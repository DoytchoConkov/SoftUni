package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Present> data;
    private String color;
    private Integer capacity;

    public Bag(String color, Integer capacity) {
        this.data = new ArrayList<>();
        this.color = color;
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String present) {
        boolean isExist = false;
        Present removePresent = null;
        for (Present currentPresent : this.data) {
            if (currentPresent.getName().equals(present)) {
                isExist = true;
                removePresent = currentPresent;
                break;
            }
        }
        if (isExist) {
            this.data.remove(removePresent);
        }
        return isExist;
    }

    public Present heaviestPresent() {
        double haviest = Integer.MIN_VALUE;
        Present haviestPresent = null;
        for (Present present : this.data) {
            if (present.getWeight() > haviest) {
                haviest = present.getWeight();
                haviestPresent = present;
            }
        }
        return haviestPresent;
    }

    public Present getPresent(String name) {
        Present currentPresent = null;
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                currentPresent = present;
            }
        }
        return currentPresent;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        String result = String.format("%s bag contains:%n", this.color);
        for (Present currentPresent : this.data) {
            result += currentPresent.toString() + "\n";
        }
        return result;
    }
}
