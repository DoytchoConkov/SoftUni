import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger number1 = new BigInteger(scan.nextLine());
        BigInteger number2 = new BigInteger(scan.nextLine());
        BigInteger sum = number1.add(number2);
        System.out.println(sum);
    }
}
