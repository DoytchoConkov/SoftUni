import java.util.Arrays;
import java.util.Scanner;

public class matrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] tokens = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int rows = tokens[0];
        int cols = tokens[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] coordinates = input.split("\\s+");
            if (coordinates[0].equals("swap") && coordinates.length == 5) {
                int row1 = Integer.parseInt(coordinates[1]);
                int col1 = Integer.parseInt(coordinates[2]);
                int row2 = Integer.parseInt(coordinates[3]);
                int col2 = Integer.parseInt(coordinates[4]);

                if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
                    System.out.println("Invalid input!");
                } else {
                    String tempElement = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = tempElement;

                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scan.nextLine();
        }
    }
}
