package Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        Point bottomLeft = new Point(numbers[0], numbers[1]);
        Point topRight = new Point(numbers[2], numbers[3]);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            numbers = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
            Point point = new Point(numbers[0], numbers[1]);
            System.out.println(rectangle.contains(point));
        }
    }
}
