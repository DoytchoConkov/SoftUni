import java.util.Scanner;

public class E04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String problemName = scan.nextLine();
        double totalMark = 0;
        int counter = 0;
        while (!problemName.equals("Finish")) {
            double problemMark = 0;
            for (int i = 0; i < n; i++) {
                double currentMark = Double.parseDouble(scan.nextLine());
                counter++;
                totalMark += currentMark;
                problemMark += currentMark;

            }
            System.out.printf("%s - %.2f.%n", problemName, problemMark / n);
            problemName = scan.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalMark / counter);
    }
}
