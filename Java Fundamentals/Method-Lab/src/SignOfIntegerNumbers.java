import java.util.Scanner;

public class SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        printSight(number);
    }

    public static void printSight(int n) {
        if (n < 0) {
            System.out.printf("The number %d is negative.", n);
        } else if (n == 0) {
            System.out.println("The number 0 is zero.");
        } else {
            System.out.printf("The number %d is positive.", n);
        }
    }
}
