import java.util.Arrays;
import java.util.Scanner;

public class maximumSumOfSubmatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] sizes = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int rows = sizes[0];
        int cols = sizes[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
        }

        int maxSum = Integer.MIN_VALUE;
        int maxSumRow = 0;
        int maxSumCol = 0;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row + 1][col] + matrix[row][col + 1] + matrix[row + 1][col + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSumRow = row;
                    maxSumCol = col;
                }
            }
        }
        System.out.printf("%d %d\n%d %d\n%d", matrix[maxSumRow][maxSumCol], matrix[maxSumRow][maxSumCol+1], matrix[maxSumRow+1][maxSumCol ], matrix[maxSumRow + 1][maxSumCol + 1], maxSum);
    }
}
