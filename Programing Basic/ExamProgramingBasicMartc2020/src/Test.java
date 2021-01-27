import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int honey = Integer.parseInt(scan.nextLine());
        double sum = 0;
        String name = scan.nextLine();
        while (!"Winter has come".equals(name)) {
            double eaten = 0;
            for (int i = 1; i <= 6; i++) {
                double n = Double.parseDouble(scan.nextLine());
                eaten += n;
                sum = sum + n;
            }
            if (sum >= honey) {
                break;
            }
            if (eaten <= 0) {
                System.out.printf("%s was banished for gluttony%n", name);
            }
            name = scan.nextLine();
        }
        if (sum >= honey) {
            System.out.printf("Well done! Honey surplus %.2f.", sum - honey);
        } else {
            System.out.printf("Hard Winter! Honey needed %.2f.", honey - sum);
        }
    }
}
