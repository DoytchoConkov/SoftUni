import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n; i++) {
            rowOfTriangle(i);
        }
        for (int i = n - 1; i >= 1; i--) {
            rowOfTriangle(i);
        }
    }

    public static void rowOfTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
