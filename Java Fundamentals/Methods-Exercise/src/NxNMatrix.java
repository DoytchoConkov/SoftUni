import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        matrix(n);
    }

    private static void matrix(int n) {
        for (int i = 0; i < n; i++) {
            matrixLine(n);
            System.out.println();
        }
    }

    private static void matrixLine(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(n+" ");
        }
    }
}
