package GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Box<Integer>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxes.add(new Box(Integer.parseInt(scan.nextLine())));
        }
        int[] token = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        swap(boxes, token[0], token[1]);
        boxes.forEach(System.out::println);

    }

    public static void swap(List<Box<Integer>> list, int first, int second) {
        Box firstElement = list.get(first);
        Box secondElement = list.get(second);
        list.set(first, secondElement);
        list.set(second, firstElement);
    }
}
