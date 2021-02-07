import java.util.Arrays;
import java.util.Scanner;

public class maximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] tokens = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int rows = tokens[0];
        int cols = tokens[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
        }

        int maxSum = Integer.MIN_VALUE;
        int maxSumRow = 0;
        int maxSumCol = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row + 1][col] + matrix[row + 2][col] + matrix[row][col + 1] +
                        matrix[row + 1][col + 1] + matrix[row + 2][col + 1] + matrix[row][col + 2] + matrix[row + 1][col + 2] + matrix[row + 2][col + 2];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSumRow = row;
                    maxSumCol = col;
                }
            }
        }
        System.out.printf("Sum = %d\n", maxSum);
        for (int row = maxSumRow; row < maxSumRow + 3; row++) {
            for (int col = maxSumCol; col < maxSumCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
