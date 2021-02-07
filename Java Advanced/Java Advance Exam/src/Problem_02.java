import java.util.Arrays;
import java.util.Scanner;

public class Problem_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        Integer[][] matrix = new Integer[numbers[0]][numbers[1]];

        for (int row = 0; row < numbers[0]; row++) {
            for (int col = 0; col < numbers[1]; col++) {
                matrix[row][col] = 0;
            }
        }
        String input = scan.nextLine();
        while (!input.equals("Bloom Bloom Plow")) {
            int[] coordinates = Arrays.stream(input.split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
            int row = coordinates[0];
            int col = coordinates[1];
            if (row < 0 || row >= numbers[0] || col < 0 || col >= numbers[1]) {
                System.out.println("Invalid coordinates.");
            } else {
                for (int i = 0; i < numbers[0]; i++) {
                    matrix[i][col]++;
                }
                for (int i = 0; i < numbers[1]; i++) {
                    if (i != coordinates[0]) {
                        matrix[row][i]++;
                    }
                }
            }

            input = scan.nextLine();
        }
        for (int row = 0; row < numbers[0]; row++) {
            for (int col = 0; col < numbers[1]; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
