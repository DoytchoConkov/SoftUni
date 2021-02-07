import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String initialString = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());
        String[][] field = new String[n][n];
        Integer[] coordinates = new Integer[2];
        String result = initialString;
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (input[j].equals("P")) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
                field[i][j] = input[j];
            }
        }

        String input = scan.nextLine();
        while (!input.equals("end")) {
            field[coordinates[0]][coordinates[1]] = "-";
            Integer[] currentCoordinates = coordinates.clone();
            movePoint(currentCoordinates, input);
            if (currentCoordinates[0] < 0 || currentCoordinates[0] >= n || currentCoordinates[1] < 0 || currentCoordinates[1] >= n) {
                result = result.substring(0, result.length() - 1);
                field[coordinates[0]][coordinates[1]]="P";
            } else {
                coordinates = currentCoordinates.clone();
                if (!field[coordinates[0]][coordinates[1]].equals("-")) {
                    result += field[coordinates[0]][coordinates[1]];
                }
                field[coordinates[0]][coordinates[1]]="P";
            }
            input = scan.nextLine();
        }
        System.out.println(result);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
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