import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sector = scan.nextLine();
        int rows = Integer.parseInt(scan.nextLine());
        int seats = Integer.parseInt(scan.nextLine());
        int counter = 0;
        int totalSeats = 0;
        for (int i = 'A'; i <= sector.charAt(0); i++) {
            for (int j = 1; j <= rows + counter; j++) {
                if (j % 2 != 0) {
                    for (int k = 'a'; k < 'a' + seats; k++) {
                        System.out.printf("%c%d%c%n", i, j, k);
                        totalSeats++;
                    }
                } else {
                    for (int k = 'a'; k < 'a' + seats + 2; k++) {
                        System.out.printf("%c%d%c%n", i, j, k);
                        totalSeats++;
                    }
                }
            }
            counter++;
        }
        System.out.println(totalSeats);
    }
}
