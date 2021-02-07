package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            cars.add(new Car(token[0], Integer.parseInt(token[1]), Integer.parseInt(token[2]), Integer.parseInt(token[3]), token[4],
                    Double.parseDouble(token[5]), Integer.parseInt(token[6]), Double.parseDouble(token[7]), Integer.parseInt(token[8]),
                    Double.parseDouble(token[9]), Integer.parseInt(token[10]), Double.parseDouble(token[11]), Integer.parseInt(token[12])));
        }
        String input = scan.nextLine();
        if (input.equals("fragile")) {
            cars.stream().forEach(e -> {
                if (e.getType().equals("fragile") && (e.getTire1Preasure() < 1 || e.getTire2Pressure() < 1 || e.getTire3Pressure() < 1 || e.getTire4Pressure() < 1)) {
                    System.out.println(e.getModel());
                }
            });
        } else {
            cars.stream().forEach(e -> {
                if (e.getPower() > 250) {
                    System.out.println(e.getModel());
                }
            });
        }
    }
}
