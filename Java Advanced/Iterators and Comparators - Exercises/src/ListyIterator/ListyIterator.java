package ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterator<String> {
    private List<String> elements;

    public ListyIterator(String... elements) {
        this.elements = Arrays.asList(elements);
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    private void setElements(String... elements) {

    }

    int cnt = 0;

    @Override
    public boolean hasNext() {
        return cnt < elements.size() - 1;
    }

    @Override
    public String next() {
        if (cnt == elements.size() - 1) {
            return "false";
        }
        this.cnt++;
        return "true";
    }

    public String print() {
        return this.elements.get(this.cnt);
    }

    public boolean move() {
        if (this.cnt < this.elements.size()) {
            this.cnt++;
            return true;
        }
        return false;
    }
}
