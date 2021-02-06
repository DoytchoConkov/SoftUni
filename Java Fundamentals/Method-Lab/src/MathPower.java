import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x = Double.parseDouble(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(new DecimalFormat("0.####").format(numberPower(x, n)));
    }

    public static double numberPower(double a, int pow) {
        double output = 1;
        for (int i = 0; i < pow; i++) {
            output = output * a;
        }
        return output;
    }
}
