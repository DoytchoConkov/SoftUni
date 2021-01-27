import java.util.Scanner;

public class PC_GameShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int heartsTone = 0;
        int fornite = 0;
        int overwatch = 0;
        int other = 0;
        for (int i = 0; i < n; i++) {
            String gameName = scan.nextLine();
            switch (gameName) {
                case "Hearthstone":
                heartsTone++;
                    break;
                case "Fornite":
                    fornite++;
                    break;
                case "Overwatch":
                    overwatch++;
                    break;
                default:
                    other++;
                    break;
            }
        }
        System.out.printf("Hearthstone - %.2f%%%n", 100.0 * heartsTone / n);
        System.out.printf("Fornite - %.2f%%%n", 100.0 * fornite / n);
        System.out.printf("Overwatch - %.2f%%%n", 100.0 * overwatch / n);
        System.out.printf("Others - %.2f%%%n", 100.0 * other / n);
    }
}
