import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalSum = Integer.parseInt(scan.nextLine());
        int avrCs = 0;
        int avrCc = 0;
        double avrCsSum = 0;
        double avrCcSum = 0;
        String imput = scan.nextLine();
        boolean flag = false;
        while (!imput.equals("End")) {
            int sum = Integer.parseInt(imput);
            if (!flag && sum <= 100) {
                flag = true;
                avrCs++;
                avrCsSum = avrCsSum + sum;
                totalSum = totalSum - sum;
                System.out.println("Product sold!");
            } else if (flag && sum > 10) {
                flag = false;
                avrCc++;
                avrCcSum = avrCcSum + sum;
                totalSum = totalSum - sum;
                System.out.println("Product sold!");
            } else {
                System.out.println("Error in transaction!");
                flag = !flag;
            }
            if (totalSum < 0) {
                break;
            }
            imput = scan.nextLine();
        }
        if (totalSum > 0) {
            System.out.println("Failed to collect required money for charity.");
        } else {
            System.out.printf("Average CS: %.2f%n", 1.0 * avrCsSum / avrCs);
            System.out.printf("Average CC: %.2f", 1.0 * avrCcSum / avrCc);
        }
    }
}
