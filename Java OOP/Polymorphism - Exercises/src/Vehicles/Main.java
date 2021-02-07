package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] token = scan.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(token[1]), Double.parseDouble(token[2]),Double.parseDouble(token[3]));
        token = scan.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(token[1]), Double.parseDouble(token[2]),Double.parseDouble(token[3]));
        token = scan.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(token[1]), Double.parseDouble(token[2]),Double.parseDouble(token[3]));
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            token = scan.nextLine().split("\\s+");
            if (token[1].equals("Car")) {
                if (token[0].equals("Drive")) {
                    car.drive(Double.parseDouble(token[2]));
                } else {
                    car.refuel (Double.parseDouble(token[2]));
                }
            } else if (token[1].equals("Truck")) {
                if (token[0].equals("Drive")) {
                    truck.drive(Double.parseDouble(token[2]));
                } else {
                    truck.refuel(Double.parseDouble(token[2]));
                }
            } else {
                if (token[0].equals("Drive")) {
                    bus.drive(Double.parseDouble(token[2]));
                } else if (token[0].equals("DriveEmpty")) {
                    bus.driveEmpty(Double.parseDouble(token[2]));
                } else{
                    bus.refuel(Double.parseDouble(token[2]));
                }
            }
        }
        System.out.printf("Car: %.2f%n", car.fuelQuantity);
        System.out.printf("Truck: %.2f%n", truck.fuelQuantity);
        System.out.printf("Bus: %.2f%n", bus.fuelQuantity);
    }
}
