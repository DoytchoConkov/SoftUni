import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] pirateShip = Arrays.stream(scan.nextLine().split(">"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] pirateShipStatus = pirateShip;
        int[] warShip = Arrays.stream(scan.nextLine().split(">"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int maxHealth = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        while (!"Retire".equals(input)) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Fire": {
                    int index = Integer.parseInt(token[1]);
                    int demolition = Integer.parseInt(token[2]);
                    if (index >= 0 && index < warShip.length) {
                        warShip[index] = warShip[index] - demolition;
                        if (warShip[index] <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                }
                break;
                case "Defend": {
                    int startIndex = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);
                    int demolition = Integer.parseInt(token[3]);
                    if (startIndex >= 0 && startIndex < pirateShip.length && endIndex >= 0 && endIndex < pirateShip.length) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip[i] = pirateShip[i] - demolition;
                            if (pirateShip[i] <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                }
                break;
                case "Repair": {
                    int index = Integer.parseInt(token[1]);
                    int repair = Integer.parseInt(token[2]);
                    if (index >= 0 && index < pirateShip.length) {
                        pirateShip[index] = pirateShip[index] + repair;
                        if (pirateShip[index] > maxHealth) {
                            pirateShip[index] = maxHealth;
                        }
                    }
                }
                break;
                case "Status":
                    int counter = 0;
                    for (int i = 0; i < pirateShip.length; i++) {
                        if (pirateShip[i] < 0.2*maxHealth) {
                            counter++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", counter);
                    break;
            }


            input = scan.nextLine();
        }
        int pirateSum = 0;
        int warShipSum = 0;
        for (int status : pirateShip) {
            pirateSum += status;
        }
        for (int status : warShip) {
            warShipSum += status;
        }
        System.out.printf("Pirate ship status: %d%n", pirateSum);
        System.out.printf("Warship status: %d", warShipSum);
    }
}
