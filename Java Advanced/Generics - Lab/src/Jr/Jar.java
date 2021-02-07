package Jr;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    Deque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove() {
        return elements.pop();
    }
}
