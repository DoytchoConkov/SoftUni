import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[][] territory = new String[n][n];

        int beeRow = -1;
        int beeCol = -1;

        for (int row = 0; row < n; row++) {
            String[] rows = scan.nextLine().split("");
            for (int col = 0; col < n; col++) {
                if (rows[col].equals("B")) {
                    beeRow = row;
                    beeCol = col;
                }
                territory[row][col] = rows[col];
            }
        }

        int pollinatedFlowers = 0;
        String input = scan.nextLine();

        while (!input.equals("End")) {
            territory[beeRow][beeCol] = ".";
            switch (input) {
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
            }
            if (beeRow < 0 || beeRow >= n || beeCol < 0 || beeCol >= n) {
                System.out.println("The bee got lost!");
                break;
            }
            if (territory[beeRow][beeCol].equals("f")) {
                pollinatedFlowers++;
            } else if (territory[beeRow][beeCol].equals("O")) {
                territory[beeRow][beeCol] = ".";
                switch (input) {
                    case "left":
                        beeCol--;
                        break;
                    case "right":
                        beeCol++;
                        break;
                    case "up":
                        beeRow--;
                        break;
                    case "down":
                        beeRow++;
                        break;
                }
                if (territory[beeRow][beeCol].equals("f")) {
                    pollinatedFlowers++;
                }
            }
            territory[beeRow][beeCol] = "B";

            input = scan.nextLine();
        }


        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(territory[row][col]);
            }
            System.out.println();
        }
    }
}
