package Car2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car;
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            car = new Car(input[0], input[1], Integer.parseInt(input[2]));
            cars.add(car);
        }

        cars.stream().forEach(e-> System.out.println(e.toString()));
    }
}
