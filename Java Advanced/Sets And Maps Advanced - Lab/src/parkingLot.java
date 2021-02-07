import java.util.LinkedHashSet;
import java.util.Scanner;

public class parkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        LinkedHashSet<String> cars = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            if (tokens[0].equals("IN")) {
                cars.add(tokens[1]);
            } else {
                cars.remove(tokens[1]);
            }
            input = scan.nextLine();
        }
        if (cars.size() == 0) {
            System.out.println("Parking Lot is Empty");
        } else {
            cars.stream().forEach(e -> System.out.println(e));
        }
    }
}
