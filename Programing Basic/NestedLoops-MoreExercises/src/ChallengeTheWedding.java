import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int man = Integer.parseInt(scan.nextLine());
        int woman = Integer.parseInt(scan.nextLine());
        int tables = Integer.parseInt(scan.nextLine());
        int counter = 1;
        for (int i = 1; i <= man; i++) {
            for (int j = 1; j <= woman; j++) {
                if (counter > tables) {
                    break;
                }
                System.out.printf("(%d <-> %d) ", i, j);
                counter++;
            }
            if (counter > tables) {
                break;
            }
        }
    }
}
