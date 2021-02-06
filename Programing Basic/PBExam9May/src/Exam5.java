import java.util.Scanner;

public class Exam5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());
        int problems = Integer.parseInt(scan.nextLine());
        int traynerPower = Integer.parseInt(scan.nextLine());
        int questions = 0;
        int problemsSolved = 0;
        while (traynerPower > 0) {
            traynerPower += problems*2;
            problemsSolved += problems;
            students -= problems;
            traynerPower -= students * 6;
            questions += students * 2;
            if (students < 10) {
                break;
            }
            students += students / 10;
        }
        if (students < 10) {
            System.out.println("The students are too few!");
            System.out.printf("Problem solved: %d", problemsSolved);
        } else {
            System.out.println("The trainer is too tired!");
            System.out.printf("Questions answere: %d", questions);
        }
    }
}
