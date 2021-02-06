import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        if (n > 0) {
            long[] fibonaci = new long[n];
            fibonaci[0] = 1L;
            if (n > 1) {
                fibonaci[1] = 1L;
            }
            for (int i = 2; i < n; i++) {
                fibonaci[i] = fibonaci[i - 1] + fibonaci[i - 2];
            }
            System.out.println(fibonaci[n - 1]);
        }else {
            System.out.println("0");
        }
    }
}
