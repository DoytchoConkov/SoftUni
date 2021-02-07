package CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public void add(T element) {
        this.customList.add(element);
    }

    public int size() {
        return this.customList.size();
    }

    public T remove(int index) {
        return customList.remove(index);
    }

    public boolean contains(T element) {
        return customList.contains(element);
    }

    public void swap(int index1, int index2) {
        T first = customList.get(index1);
        T second = customList.get(index2);
        customList.set(index1, second);
        customList.set(index2, first);
    }

    public int countGreaterThan(T element) {
        int cnt = 0;
        for (T el : customList) {
            if (el.compareTo(element) > 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public T getMax() {
        T maxElement = customList.get(0);
        for (T el : customList) {
            if (el.compareTo(maxElement) > 0) {
                maxElement = el;
            }
        }
        return maxElement;
    }

    public T getMin() {
        T minElement = customList.get(0);
        for (T el : customList) {
            if (el.compareTo(minElement) < 0) {
                minElement = el;
            }
        }
        return minElement;
    }

    public void print() {
        for (T el : customList) {
            System.out.println(el);
        }
    }

    protected T get(int index) {
        return this.customList.get(index);
    }
}

