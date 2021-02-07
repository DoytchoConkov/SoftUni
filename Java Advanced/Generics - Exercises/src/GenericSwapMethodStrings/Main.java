package GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Box<String>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxes.add(new Box<>(scan.nextLine()));
        }
        int[] token = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        swap(boxes, token[0], token[1]);
        boxes.stream().forEach(e -> System.out.println(e));

    }

    public static void swap(List<Box<String>> list, int first, int second) {
        Box<String> firstElement = list.get(first);
        Box<String> secondElement = list.get(second);
        list.set(first, secondElement);
        list.set(second, firstElement);
    }
}