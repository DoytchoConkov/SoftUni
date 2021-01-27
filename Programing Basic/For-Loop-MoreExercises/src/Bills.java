import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mounts = Integer.parseInt(scan.nextLine());
        double tokTotal = 0;
        for (int i = 0; i < mounts; i++) {
            double tok = Double.parseDouble(scan.nextLine());
            tokTotal = tokTotal + tok;
        }
        double waterTotal = mounts * 20;
        double internetTotal = mounts * 15;
        double otherTotal = (tokTotal + waterTotal + internetTotal) * 1.2;
        System.out.printf("Electricity: %.2f lv%n", tokTotal);
        System.out.printf("Water: %.2f lv%n", waterTotal);
        System.out.printf("Internet: %.2f lv%n", internetTotal);
        System.out.printf("Other: %.2f lv%n", otherTotal);
        System.out.printf("Average: %.2f lv", (tokTotal + waterTotal + internetTotal + otherTotal) / mounts);
    }
}
