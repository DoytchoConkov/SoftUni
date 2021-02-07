import java.util.Arrays;
import java.util.Scanner;

public class sumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] sizes = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int [][] matrix=new int [sizes[0]][sizes[1]];
        for (int row = 0; row < sizes[0]; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
        }
        System.out.println(sizes[0]);
        System.out.println(sizes[1]);
        int sum=0;
        for (int row = 0; row < sizes[0]; row++) {
            for (int col = 0; col < sizes[1]; col++) {
                sum+=matrix[row][col];
            }
        }
        System.out.println(sum);
    }
}
