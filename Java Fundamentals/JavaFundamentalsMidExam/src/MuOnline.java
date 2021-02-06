import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bitcoins = 0;
        int health = 100;
        int bestRoom = 0;
        String[] rooms = scan.nextLine().split("\\|");
        for (int i = 0; i < rooms.length; i++) {
            bestRoom = i + 1;
            String[] command = rooms[i].split("\\s+");
            if ("potion".equals(command[0])) {
                int cure = Integer.parseInt(command[1]);
                if (health + cure <= 100) {
                    System.out.printf("You healed for %d hp.%n", cure);
                    health += cure;
                } else {
                    System.out.printf("You healed for %d hp.%n", 100 - health);
                    health = 100;
                }
                System.out.printf("Current health: %d hp.%n", health);
            } else if ("chest".equals(command[0])) {
                int foudedBitkoins = Integer.parseInt(command[1]);
                bitcoins += foudedBitkoins;
                System.out.printf("You found %d bitcoins.%n", foudedBitkoins);
            } else {
                int strenght = Integer.parseInt(command
                        [1]);
                health -= strenght;
                if (health <= 0) {
                    System.out.printf("You died! Killed by %s.%n", command[0]);
                    System.out.printf("Best room: %d%n", bestRoom);
                    break;
                } else {
                    System.out.printf("You slayed %s.%n", command[0]);
                }
            }
        }
        if (health > 0) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", health);
        }
    }
}
