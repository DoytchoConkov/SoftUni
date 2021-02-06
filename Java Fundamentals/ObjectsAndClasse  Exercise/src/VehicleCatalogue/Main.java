package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<VehicleCatalogue> vehisles = new ArrayList<>();
        while (!"End".equals(input)) {
            String[] token = input.split("\\s+");
            if (token[0].equals("car")) {
                token[0] = "Car";
            } else {
                token[0] = "Truck";
            }
            VehicleCatalogue vehicle = new VehicleCatalogue(token[0], token[1], token[2], Integer.parseInt(token[3]));
            vehisles.add(vehicle);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!"Close the Catalogue".equals(input)) {
            for (VehicleCatalogue vehicle : vehisles) {
                if (vehicle.getModel().equals(input)) {
                    vehicle.printVehicle();
                }
            }
            input = scan.nextLine();
        }
        int cntCars = 0;
        int cntTrucks = 0;
        double avrCars = 0;
        double avrTrucs = 0;
        for (VehicleCatalogue vehicle : vehisles) {
            if (vehicle.getType().equals("Car")) {
                cntCars++;
                avrCars += vehicle.getHorsepower();
            } else {
                cntTrucks++;
                avrTrucs += vehicle.getHorsepower();
            }
        }
        if (cntCars == 0) {
            avrCars = 0;
        } else {
            avrCars = avrCars / cntCars;
        }
        if (cntTrucks == 0) {
            avrTrucs = 0;
        } else {
            avrTrucs = avrTrucs / cntTrucks;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", avrCars);
        System.out.printf("Trucks have average horsepower of: %.2f.", avrTrucs);
    }
}
