package CustomListSorter;

public class CustomListSorter<T> extends CustomList {

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T e1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                T e2 = list.get(j);
                if (e1.compareTo(e2) > 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
