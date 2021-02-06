import java.util.Scanner;

public class Exam6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!"Midnight".equals(input)) {
            int sum = 0;
            for (int i = 0; i < 6; i++) {
                int grade = Integer.parseInt(scan.nextLine());
                if (grade < 0) {
                    System.out.printf("%s was cheating!%n", input);
                    break;
                }
                sum += grade;
            }
            double avrGrade = Math.floor(sum / 6) * 0.06;
            if (avrGrade < 3) {
                avrGrade = 2;
            }
            if (avrGrade >= 5) {
                System.out.println("===================");
                System.out.println("|   CERTIFICATE   |");
                System.out.printf("|    %.2f/6.00    |%n", avrGrade);
                System.out.println("===================");
                System.out.printf("Issued to %s%n", input);
            } else {
                System.out.printf("%s - %.2f%n", input, avrGrade);
            }
            input = scan.nextLine();
        }
    }
}
