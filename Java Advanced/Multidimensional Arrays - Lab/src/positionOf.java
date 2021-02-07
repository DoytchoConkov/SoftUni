import java.util.Arrays;
import java.util.Scanner;

public class positionOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] token = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int rows = token[0];
        int cols = token[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
        }
        int number = Integer.parseInt(scan.nextLine());
        boolean isFound=false;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == number) {
                    System.out.println(row + " " + col);
                    isFound=true;
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }
}
