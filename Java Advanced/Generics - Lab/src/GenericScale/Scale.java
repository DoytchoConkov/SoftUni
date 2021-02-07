package GenericScale;

public class Scale<T extends  Comparable<T>> {
    T left;
    T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        return  left.compareTo(right)>0? left:right;
    }

}
