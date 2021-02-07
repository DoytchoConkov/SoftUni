import java.util.Arrays;
import java.util.Scanner;

public class matrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] tokens = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int rows = tokens[0];
        int cols = tokens[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String currentElement = "" + (char) ('a' + row) + (char) ('a' + row + col) + (char) ('a' + row);
                matrix[row][col] = currentElement;
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
