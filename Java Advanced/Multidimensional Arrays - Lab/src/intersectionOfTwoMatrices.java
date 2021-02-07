import java.util.Arrays;
import java.util.Scanner;

public class intersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows =Integer.parseInt(scan.nextLine());
        int cols =Integer.parseInt(scan.nextLine());

        char[][] matrix1 = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scan.nextLine().split("\\s+");
            for (int col = 0; col <cols; col++) {
                matrix1[row][col] = input[col].charAt(0);
            }
        }
        char[][] matrix2 = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scan.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix2[row][col] = input[col].charAt(0);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix1[row][col] == matrix2[row][col]) {
                    System.out.printf("%c ", matrix1[row][col]);
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}