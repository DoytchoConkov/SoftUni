package Collection;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
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

    public String print() {
        return this.elements.get(this.cnt);
    }

    public boolean next() {
        if (this.cnt < this.elements.size()) {
            this.cnt++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.cnt < this.elements.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index<elements.size();
            }

            @Override
            public String next() {
                return elements.get(this.index++);
            }
        };
    }
}

