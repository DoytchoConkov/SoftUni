import java.util.Arrays;
import java.util.Scanner;

public class reverceMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] sizes = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int rows = sizes[0];
        int cols = sizes[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
        }

        int cnt = rows - 1;

        for (int col = cols - 1; col >= 0; col--) {
            for (int col2 = col; col2 < cols; col2++) {
                System.out.print(matrix[cnt][col2] + " ");
                cnt--;
                if (cnt < 0) {
                    break;
                }
            }
            cnt = rows - 1;
            System.out.println();
        }

        for (int row = rows - 2; row >= 0; row--) {
            cnt = row;
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[cnt][col] + " ");
                cnt--;
                if (cnt < 0) {
                    break;
                }
            }
            System.out.println();
        }

    }
}

