import java.util.Scanner;

public class SumofOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + 2 * i + 1;
            System.out.println(2 * i + 1);
        }
        String text = String.format("Sum: %d", sum);
        System.out.println(text);
    }
}
