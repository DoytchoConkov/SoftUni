import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String imput = scan.nextLine();
        int sumPrime = 0;
        int sumNonPrime = 0;
        while (!imput.equals("stop")) {
            int number = Integer.parseInt(imput);
            boolean flag = false;
            if (number >= 0) {
                for (int i = 2; i < number; i++) {
                    if (number % i == 0) {
                        flag = true;
                    }
                }
                if (flag) {
                    sumNonPrime += number;
                } else {
                    sumPrime += number;
                }
            } else {
                System.out.println("Number is negative.");
            }
            imput = scan.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d%n", sumNonPrime);
    }
}
