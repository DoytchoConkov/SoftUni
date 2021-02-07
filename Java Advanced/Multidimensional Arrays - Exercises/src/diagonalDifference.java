import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;

public class diagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
        }
        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;
        for (int row = 0; row < size; row++) {
            firstDiagonalSum += matrix[row][row];
            secondDiagonalSum += matrix[size - 1 - row][row];
        }
        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }
}
