package ArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {
    public static <T> T[] create(int lenght, T ithem) {
        T[] array = (T[]) new Object[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i] = ithem;
        }
        return array;
    }
    public static <T> T[] create(Class<T> clazz,int lenght, T ithem) {
        T[] array = (T[]) Array.newInstance(clazz,lenght);
        for (int i = 0; i < lenght; i++) {
            array[i] = ithem;
        }
        return array;
    }
}
