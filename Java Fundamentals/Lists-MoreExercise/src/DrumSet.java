import java.util.Arrays;
import java.util.Scanner;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double savings = Double.parseDouble(scan.nextLine());
        int[] drums = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] temp = new int[drums.length];
        for (int i = 0; i < drums.length; i++) {
            temp[i] = drums[i];
        }
        String input = scan.nextLine();
        while (!"Hit it again, Gabsy!".equals(input)) {
            int powerGabsy = Integer.parseInt(input);
            for (int i = 0; i < drums.length; i++) {
                temp[i] = temp[i] - powerGabsy;
                if (temp[i] <= 0) {
                    if (savings - drums[i] * 3 >= 0) {
                        savings = savings - drums[i] * 3;
                        temp[i] = drums[i];
                    }
                }
            }
            input = scan.nextLine();
        }
        for (int n : temp) {
            if (n > 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
