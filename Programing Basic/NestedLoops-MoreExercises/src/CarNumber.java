import java.util.Scanner;

public class CarNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        for (int i = number1; i <= number2; i++) {
            for (int j = number1; j <= number2; j++) {
                for (int k = number1; k <= number2; k++) {
                    for (int l = number1; l < number2; l++) {
                        if (i % 2 == 0 && l % 2 != 0 && i > l && (j + k) % 2 == 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                        if (i % 2 != 0 && l % 2 == 0 && i > l && (j + k) % 2 == 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }

                }
            }
        }


    }
}
