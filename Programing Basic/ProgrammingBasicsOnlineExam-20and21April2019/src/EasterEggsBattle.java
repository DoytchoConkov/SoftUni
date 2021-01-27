import java.util.Scanner;

public class EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int eggs1 = Integer.parseInt(scan.nextLine());
        int eggs2 = Integer.parseInt(scan.nextLine());
        String imput = scan.nextLine();
        while (!imput.equals("End of battle")) {
            if (imput.equals("one")) {

                eggs2--;
            } else {
                eggs1--;

            }
            if (eggs1 == 0 || eggs2 == 0) {
                break;
            }
            imput= scan.nextLine();
        }
        if (eggs1 == 0) {
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.", eggs2);
        } else if (eggs2 == 0) {
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.", eggs1);
        } else {
            System.out.printf("Player one has %d eggs left.%n", eggs1);
            System.out.printf("Player two has %d eggs left.", eggs2);
        }
    }
}
