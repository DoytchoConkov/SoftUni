package Vehicles1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] token = scan.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(token[1]), Double.parseDouble(token[2]));
        token = scan.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(token[1]), Double.parseDouble(token[2]));
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            token = scan.nextLine().split("\\s+");
            if (token[1].equals("Car")) {
                if (token[0].equals("Drive")) {
                    System.out.println(car.drive(Double.parseDouble(token[2])));
                } else {
                    car.refill(Double.parseDouble(token[2]));
                }
            } else {
                if (token[0].equals("Drive")) {
                    System.out.println(truck.drive(Double.parseDouble(token[2])));
                } else {
                    truck.refill(Double.parseDouble(token[2]));
                }
            }
        }
        System.out.printf("Car: %.2f%n",car.fuelQuantity);
        System.out.printf("Truck: %.2f%n",truck.fuelQuantity);
    }
}
