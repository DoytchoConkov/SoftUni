import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int presents = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        String[][] neighbourhood = new String[n][n];
        Integer[] coordinates = new Integer[2];
        int niceKids = 0;
        int happyKids = 0;

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                if (input[j].equals("S")) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
                if (input[j].equals("V")) {
                    niceKids++;
                    happyKids++;
                }
                neighbourhood[i][j] = input[j];
            }
        }

        String input = scan.nextLine();
        while (!input.equals("Christmas morning") && presents > 0) {
            neighbourhood[coordinates[0]][coordinates[1]] = "-";
            movePoint(coordinates, input);
            if (neighbourhood[coordinates[0]][coordinates[1]].equals("V")) {
                niceKids--;
                presents--;
            }
            if (neighbourhood[coordinates[0]][coordinates[1]].equals("C")) {
                int up = coordinates[0] - 1;
                int down = coordinates[0] + 1;
                int left = coordinates[1] - 1;
                int right = coordinates[1] + 1;
                if (up < 0) up = 0;
                if (down > n) down = n - 1;
                if (left < 0) left = 0;
                if (right > n) right = n - 1;

                for (int i = up; i <= down; i++) {
                    for (int j = left; j <= right; j++) {
                        if (neighbourhood[i][j].equals("V") || neighbourhood[i][j].equals("X")) {
                            neighbourhood[i][j] = "-";
                            niceKids--;
                            presents--;
                        }
                    }
                }

            }
            neighbourhood[coordinates[0]][coordinates[1]] = "S";
            if (presents == 0) {
                break;
            }
            input = scan.nextLine();
        }

        if (niceKids > 0) {
            System.out.println("Santa ran out of presents.");
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(neighbourhood[row][col]);
            }
            System.out.println();
        }
        if (niceKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", happyKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.%n", niceKids);
        }

    }

    public static void movePoint(Integer[] coordinates, String input) {
        switch (input) {
            case "left":
                coordinates[1]--;
                break;
            case "right":
                coordinates[1]++;
                break;
            case "up":
                coordinates[0]--;
                break;
            case "down":
                coordinates[0]++;
                break;
        }
    }
}
