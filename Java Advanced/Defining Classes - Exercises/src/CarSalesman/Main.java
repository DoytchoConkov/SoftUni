package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        Map<String, Engine> engines = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            if (token.length == 4) {
                engines.put(token[0], new Engine(token[0], token[1], token[2], token[3]));
            } else if (token.length == 2) {
                engines.put(token[0], new Engine(token[0], token[1], "n/a", "n/a"));
            } else {
                if (token[2].length() == 1) {
                    engines.put(token[0], new Engine(token[0], token[1], "n/a", token[2]));
                } else {
                    engines.put(token[0], new Engine(token[0], token[1], token[2], "n/a"));
                }
            }
        }

        n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            if (token.length == 4) {
                cars.add(new Car(token[0], token[1], token[2], token[3]));
            } else if (token.length == 2) {
                cars.add(new Car(token[0], token[1], "n/a", "n/a"));
            } else {
                if (Character.isDigit(token[2].charAt(0))) {
                    cars.add(new Car(token[0], token[1], token[2], "n/a"));
                } else {
                    cars.add(new Car(token[0], token[1], "n/a", token[2]));
                }
            }
        }

        for (Car car : cars) {
            System.out.println(car.getModel()+":");
            System.out.println(car.getEngine()+":");
            System.out.println("Power: " + engines.get(car.getEngine()).getPower());
            System.out.println("Displacement: " + engines.get(car.getEngine()).getDisplacement());
            System.out.println("Efficiency: " + engines.get(car.getEngine()).getEfficiency());
            System.out.println("Weight: " + car.getWeight());
            System.out.println("Color: " + car.getColor());
        }
    }
}
