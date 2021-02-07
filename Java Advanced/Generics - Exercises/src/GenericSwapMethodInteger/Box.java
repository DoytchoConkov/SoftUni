package GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
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
}