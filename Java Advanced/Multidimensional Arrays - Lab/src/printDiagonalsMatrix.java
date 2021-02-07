import java.util.Arrays;
import java.util.Scanner;

public class printDiagonalsMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
        }

        for (int row = 0; row < size; row++) {
            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();
        for (int row = 0; row < size; row++) {
            System.out.print(matrix[size - 1 - row][row]+" ");
        }
        System.out.println();
    }
}
