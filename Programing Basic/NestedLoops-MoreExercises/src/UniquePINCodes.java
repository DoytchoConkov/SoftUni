import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        int number3 = Integer.parseInt(scan.nextLine());
        for (int i = 2; i <= number1; i = i + 2) {
            for (int j = 2; j <= number2; j++) {
                boolean flag = false;
                for (int k = 2; k <= number3; k = k + 2) {
                    for (int l = 2; l <= j; l++) {
                        if (j % l == 0) {
                            flag = true;
                        }
                        if (!flag||j==2) {
                            System.out.println(i + " " + j + " " + k);
                            break;
                        }
                    }
                }
            }
        }
    }
}
