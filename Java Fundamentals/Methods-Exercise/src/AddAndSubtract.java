import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nuber1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        int number3 = Integer.parseInt(scan.nextLine());
        int sum = addnumbers(nuber1, number2);
        int result = subtract(sum, number3);
        System.out.println(result);

    }

    private static int subtract(int sum, int number3) {
        return sum - number3;
    }

    private static int addnumbers(int nuber1, int number2) {
        return nuber1 + number2;
    }
}
