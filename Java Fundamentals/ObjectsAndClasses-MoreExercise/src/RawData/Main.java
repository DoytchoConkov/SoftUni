package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<CargoCar> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            CargoCar car = new CargoCar(token[0], Integer.parseInt(token[1]), Integer.parseInt(token[2]),
                    Integer.parseInt(token[3]), token[4], Double.parseDouble(token[5]), Integer.parseInt(token[6]),
                    Double.parseDouble(token[7]), Integer.parseInt(token[8]), Double.parseDouble(token[9]),
                    Integer.parseInt(token[10]), Double.parseDouble(token[11]), Integer.parseInt(token[12]));
            cars.add(car);
        }

        String command = scan.nextLine();
        if ("fragile".equals(command)) {
            for (CargoCar car : cars) {
                if (car.getCargoType().equals("fragile") && (car.getTirePressure1() < 1.0 ||
                        car.getTirePressure2() < 1.0 || car.getTirePressure3() < 1.0 || car.getTirePressure4() < 1.0)) {
                    System.out.println(car.getModel());
                }
            }
        } else if ("flamable".equals(command)) {
            for (CargoCar car : cars) {
                if (car.getCargoType().equals("flamable") && car.getEnginePower() > 250) {
                    System.out.println(car.getModel());
                }
            }
        }
    }
}
