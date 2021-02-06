package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split(" ");
            Engine engine;
            if (token.length == 4) {
                engine = new Engine(token[0], token[1], token[2], token[3]);
            } else if (token.length == 2) {
                engine = new Engine(token[0], token[1], "n/a", "n/a");
            } else {
                boolean isOnlyDigits = true;
                for (int j = 0; j < token[2].length(); j++) {
                    if (!Character.isDigit(token[2].charAt(j))) {
                        isOnlyDigits = false;
                    }
                }
                if (isOnlyDigits) {
                    engine = new Engine(token[0], token[1], token[2], "n/a");
                } else {
                    engine = new Engine(token[0], token[1], "n/a", token[2]);
                }
            }
            engines.add(engine);
        }
        List<Car> cars = new ArrayList<>();
        int m = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < m; i++) {
            String[] token = scan.nextLine().split(" ");
            Car car;
            if (token.length == 4) {
                car = new Car(token[0], token[1], token[2], token[3]);
            } else if (token.length == 2) {
                car = new Car(token[0], token[1], "n/a", "n/a");
            } else {

                boolean isOnlyDigits = true;
                for (int j = 0; j < token[2].length(); j++) {
                    if (!Character.isDigit(token[2].charAt(j))) {
                        isOnlyDigits = false;
                    }
                }
                if (isOnlyDigits) {
                    car = new Car(token[0], token[1], token[2], "n/a");
                } else {
                    car = new Car(token[0], token[1], "n/a", token[2]);
                }
            }
            cars.add(car);
        }

        for (Car car : cars) {
            for (Engine engine : engines) {
                if (car.getEngine().equals(engine.getModel())) {

                    System.out.println(car.toString(engine));
                }
            }
        }
    }
}
