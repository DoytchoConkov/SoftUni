import java.util.*;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String[][] territory = new String[n][n];
        Integer[] coordinates = new Integer[2];

        List<Integer[]> lairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (input[j].equals("S")) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
                if (input[j].equals("B")) {
                    Integer[] coord = {i, j};
                    lairs.add(coord);
                }
                territory[i][j] = input[j];
            }
        }

        int eatenFood = 0;
        String input = scan.nextLine();
        while (eatenFood <= 10) {

            territory[coordinates[0]][coordinates[1]] = ".";
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
            if (coordinates[0] < 0 || coordinates[0] >= n || coordinates[1] < 0 || coordinates[1] >= n) {
                System.out.println("Game over!");
                break;
            }
            if (territory[coordinates[0]][coordinates[1]].equals("*")) {
                eatenFood++;
            }
            if (territory[coordinates[0]][coordinates[1]].equals("B")) {
                if (lairs.get(0)[0] == coordinates[0] && lairs.get(0)[1] == coordinates[1]) {
                    territory[coordinates[0]][coordinates[1]] = ".";
                    coordinates = lairs.get(1);
                } else {
                    territory[coordinates[0]][coordinates[1]] = ".";
                    coordinates = lairs.get(0);
                }
            }
            territory[coordinates[0]][coordinates[1]] = "S";
            if (eatenFood >= 10) {
                break;
            }
            input = scan.nextLine();
        }
        if (eatenFood >= 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", eatenFood);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(territory[row][col]);
            }
            System.out.println();
        }
    }
}
