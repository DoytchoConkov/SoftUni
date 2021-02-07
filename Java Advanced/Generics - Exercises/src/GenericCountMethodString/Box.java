package GenericCountMethodString;

public class Box<T extends Comparable<T>> implements Comparable<T>{
    T elements;

    public Box(T elements) {
        this.elements = elements;
    }

    public void Box(int first, int second) {

    }

    @Override
    public String toString() {
        return this.elements.getClass().getName() + ": " + this.elements;
    }

    @Override
    public int compareTo(T o) {
        return this.elements.compareTo(o);
    }
}
