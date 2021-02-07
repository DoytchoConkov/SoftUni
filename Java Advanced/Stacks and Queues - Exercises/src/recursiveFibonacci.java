import java.util.*;

public class recursiveFibonacci {
    public static long[] fibo;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        fibo=new long[n+1];

        System.out.println(fib(n));
    }

    private static long fib(int n) {
        if (n <= 1) {
            return 1;
        }
        if (fibo[n] != 0) {
            return fibo[n];
        }
        return fibo[n]=fib(n-1)+fib(n-2);
    }
}
