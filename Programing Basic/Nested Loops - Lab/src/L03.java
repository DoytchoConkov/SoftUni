import java.util.Scanner;

public class L03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int counter = 0;
        for (int i = 0; i <= number; i++) {
            for (int j = 0; j <= number; j++) {
                for (int k = 0; k <= number; k++) {
                    if (number == i + j + k) {
                        counter++;
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
