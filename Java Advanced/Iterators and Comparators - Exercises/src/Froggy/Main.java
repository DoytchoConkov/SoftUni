package Froggy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] stones = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Lake lake = new Lake(stones);

        for (Integer stone : lake) {
            System.out.println(stone + " ");
        }
    }
}
