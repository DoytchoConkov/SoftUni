import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] line1 = new String[n];
        String[] line2 = new String[n];
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] temporalyString = input.split(" ");
            if (i % 2 == 0) {
                line1[i] = temporalyString[0];
                line2[i] = temporalyString[1];
            } else {
                line2[i] = temporalyString[0];
                line1[i] = temporalyString[1];
            }
        }
        System.out.println(String.join(" ", line1));
        System.out.println(String.join(" ", line2));
    }
}
