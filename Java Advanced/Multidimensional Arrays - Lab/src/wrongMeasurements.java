import java.util.Arrays;
import java.util.Scanner;

public class wrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
        }
        int[] coordinates = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int wrongNumber = matrix[coordinates[0]][coordinates[1]];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    int upNumber = 0;
                    int downNumber = 0;
                    int leftNumber = 0;
                    int rigthNumber = 0;
                    if (row - 1 >= 0) {
                        if (matrix[row - 1][col] != wrongNumber) {
                            upNumber = matrix[row - 1][col];
                        }
                    }
                    if (row + 1 < rows) {
                        if (matrix[row + 1][col] != wrongNumber) {
                            downNumber = matrix[row + 1][col];
                        }
                    }
                    if (col - 1 >= 0) {
                        if (matrix[row][col - 1] != wrongNumber) {
                            leftNumber = matrix[row][col - 1];
                        }
                    }
                    if (col + 1 < matrix[row].length) {
                        if (matrix[row][col + 1] != wrongNumber) {
                            rigthNumber = matrix[row][col + 1];
                        }
                    }
                    matrix[row][col] = upNumber + downNumber + leftNumber + rigthNumber;
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
