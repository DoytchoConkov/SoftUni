import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rotation = Integer.parseInt(scan.nextLine().split("[()]")[1]) % 360;
        ArrayList<String> lines = new ArrayList<>();
        int maxLenght = 0;
        String input = scan.nextLine();
        while (!input.equals("END")) {
            if (input.length() > maxLenght) {
                maxLenght = input.length();
            }
            lines.add(input);
            input = scan.nextLine();
        }
        int rows = lines.size();
        int cols = maxLenght;
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < lines.get(row).length()) {
                    matrix[row][col] = "" + lines.get(row).charAt(col);
                } else {
                    matrix[row][col] = " ";
                }
            }
        }
        if (rotation == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
        if (rotation == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
        if (rotation == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
        if (rotation == 0) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }

    }
}
