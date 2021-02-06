import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] number = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(scan.nextLine());
            sum += number[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
