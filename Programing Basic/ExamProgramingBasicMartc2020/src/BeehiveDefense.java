import java.util.Scanner;

public class BeehiveDefense {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int beeCount = Integer.parseInt(scan.nextLine());
        int health = Integer.parseInt(scan.nextLine());
        int attack = Integer.parseInt(scan.nextLine());
        while (beeCount >= 100) {
            beeCount = beeCount - attack;
            health = health - beeCount * 5;
            if (health <= 0) {
                break;
            }
        }
        if (beeCount < 0) {
            beeCount = 0;
        }
        if (health <= 0) {
            System.out.printf("Beehive won! Bees left %d.", beeCount);
        } else {
            System.out.printf("The bear stole the honey! Bees left %d.", beeCount);
        }
    }
}
