import java.util.Scanner;

public class fillMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] token = scan.nextLine().split(", ");
        int size = Integer.parseInt(token[0]);
        int[][] matrix = new int[size][size];
        if (token[1].equals("A")) {
            int number = 1;
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = number++;
                }
            }
        } else if (token[1].equals("B")) {
            int number = 1;
            for (int col = 0; col < size; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = number++;
                    }
                } else {
                    for (int row = size - 1; row >= 0; row--) {
                        matrix[row][col] = number++;
                    }
                }
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
