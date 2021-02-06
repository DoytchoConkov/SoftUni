import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number1 = Double.parseDouble(scan.nextLine());
        double number2 = Double.parseDouble(scan.nextLine());
        double n1 = number1 * 1000000;
        double n2 = number2 * 1000000;
        if (Math.abs(n1) - Math.abs(n2) < 1) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
