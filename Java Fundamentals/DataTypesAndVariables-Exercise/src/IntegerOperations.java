import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        int number3 = Integer.parseInt(scan.nextLine());
        int number4 = Integer.parseInt(scan.nextLine());
        int result = (number1 + number2) / number3 * number4;
        System.out.println(result);
    }
}
