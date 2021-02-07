import java.util.Arrays;
import java.util.Scanner;

public class compareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers1 = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int[][] matrix1 = new int[numbers1[0]][numbers1[1]];

        for (int row = 0; row < numbers1[0]; row++) {
            matrix1[row] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[] numbers2 = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int[][] matrix2 = new int[numbers2[0]][numbers2[1]];

        for (int row = 0; row < numbers2[0]; row++) {
            matrix2[row] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        boolean isEqual = true;
        if (numbers1[0] != numbers2[0] || numbers1[1] != numbers2[1]) {
            isEqual = false;
        } else {
            for (int row = 0; row < numbers2[0]; row++) {
                for (int col = 0; col < numbers2[1]; col++) {
                    if (matrix1[row][col] != matrix2[row][col]) {
                        isEqual = false;
                        break;
                    }

                }
            }
        }

        if (isEqual) {
            System.out.printf("equal");
        } else {
            System.out.printf("not equal");
        }
    }
}
