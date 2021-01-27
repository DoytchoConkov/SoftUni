import java.util.Scanner;

public class L04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        int magicNumber = Integer.parseInt(scan.nextLine());
        int counter = 0;
        for (int i = number1; i <= number2; i++) {
            for (int j = number1; j <= number2; j++) {
                counter++;
                if (i + j == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, i, j, i+j);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", counter, magicNumber);
    }
}
