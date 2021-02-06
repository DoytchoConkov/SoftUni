import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> carDistances = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\|");
            carDistances.put(tokens[0], Integer.parseInt(tokens[1]));
            carFuel.put(tokens[0], Integer.parseInt(tokens[2]));
        }
        String input = scan.nextLine();
        while (!"Stop".equals(input)) {
            String[] comands = input.split(" : ");
            String carName = comands[1];
            switch (comands[0]) {
                case "Drive":
                    int distance = Integer.parseInt(comands[2]);
                    int fuel = Integer.parseInt(comands[3]);
                    if (fuel < carFuel.get(carName)) {
                        carFuel.put(carName, carFuel.get(carName) - fuel);
                        carDistances.put(carName, carDistances.get(carName) + distance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n"
                                , carName, distance, fuel);
                        if (carDistances.get(carName) > 100000) {
                            System.out.printf("Time to sell the %s!%n", carName);
                            carDistances.remove(carName);
                            carFuel.remove(carName);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    int refillFuel = Integer.parseInt(comands[2]);
                    int carTank = carFuel.get(carName);
                    if (carTank + refillFuel > 75) {
                        refillFuel = 75 - carTank;
                    }
                    carFuel.put(carName, carTank + refillFuel);
                    System.out.printf("%s refueled with %d liters%n", carName, refillFuel);
                    break;
                case "Revert":
                    int revertKilometers = Integer.parseInt(comands[2]);
                    int carKilometrs = carDistances.get(carName);
                    if (carKilometrs - revertKilometers < 10000) {
                        carDistances.put(carName, 10000);
                    } else {
                        carDistances.put(carName, carKilometrs - revertKilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", carName, revertKilometers);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        carDistances
                .entrySet()
                .stream()
                .sorted((e1, e2) ->
                        e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue(), carFuel.get(e.getKey()));
                });
    }
}

