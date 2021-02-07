import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int cntCommands = Integer.parseInt(scan.nextLine());

        String[][] terrytory = new String[n][n];
        Integer[] coordinates = new Integer[2];
        Integer[] finishLine = new Integer[2];

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (input[j].equals("f")) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    terrytory[i][j] = "-";
                } else {
                    if (input[j].equals("F")) {
                        finishLine[0] = i;
                        finishLine[1] = j;
                    }
                    terrytory[i][j] = input[j];
                }
            }
        }

        for (int i = 0; i < cntCommands; i++) {
            Integer[] currentCoordinates = new Integer[2];
            currentCoordinates[0] = coordinates[0];
            currentCoordinates[1] = coordinates[1];
            String input = scan.nextLine();
            switch (input) {
                case "left":
                    currentCoordinates[1]--;
                    break;
                case "right":
                    currentCoordinates[1]++;
                    break;
                case "up":
                    currentCoordinates[0]--;
                    break;
                case "down":
                    currentCoordinates[0]++;
                    break;
            }
            if (currentCoordinates[0] < 0) {
                currentCoordinates[0] = n - 1;
            }
            if (currentCoordinates[0] == n) {
                currentCoordinates[0] = 0;
            }
            if (currentCoordinates[1] < 0) {
                currentCoordinates[1] = n - 1;
            }
            if (currentCoordinates[1] == n) {
                currentCoordinates[1] = 0;
            }
            if (!terrytory[currentCoordinates[0]][currentCoordinates[1]].equals("T")) {
                coordinates[0] = currentCoordinates[0];
                coordinates[1] = currentCoordinates[1];
                if (terrytory[currentCoordinates[0]][currentCoordinates[1]].equals("B")) {
                    switch (input) {
                        case "left":
                            currentCoordinates[1]--;
                            break;
                        case "right":
                            currentCoordinates[1]++;
                            break;
                        case "up":
                            currentCoordinates[0]--;
                            break;
                        case "down":
                            currentCoordinates[0]++;
                            break;
                    }
                    if (currentCoordinates[0] < 0) {
                        currentCoordinates[0] = n - 1;
                    }
                    if (currentCoordinates[0] == n) {
                        currentCoordinates[0] = 0;
                    }
                    if (currentCoordinates[1] < 0) {
                        currentCoordinates[1] = n - 1;
                    }
                    if (currentCoordinates[1] == n) {
                        currentCoordinates[1] = 0;
                    }
                    coordinates[0] = currentCoordinates[0];
                    coordinates[1] = currentCoordinates[1];
                }

            }
            if ((terrytory[coordinates[0]][coordinates[1]].equals("F"))) {
                break;
            }
        }
        if (coordinates[0] == finishLine[0] && coordinates[1] == finishLine[1]) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        terrytory[coordinates[0]][coordinates[1]] = "f";

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(terrytory[row][col]);
            }
            System.out.println();
        }
    }
}
