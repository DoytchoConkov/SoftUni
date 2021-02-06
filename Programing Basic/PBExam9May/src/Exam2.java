import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int problem = Integer.parseInt(scan.nextLine());
        int points = Integer.parseInt(scan.nextLine());
        String grade = scan.nextLine();
        double coeficent = 0;
        switch (grade) {
            case "Basics":
                if (problem == 1) {
                    coeficent = 8 * 0.8;
                } else if (problem == 2 || problem == 3) {
                    coeficent = 9;
                } else if (problem == 4) {
                    coeficent = 10;
                }
                break;
            case "Fundamental":
                if (problem == 1 || problem == 2) {
                    coeficent = 11;
                } else if (problem == 3) {
                    coeficent = 12;
                } else if (problem == 4) {
                    coeficent = 13;
                }
                break;
            case "Advanced":
                if (problem == 1 || problem == 2) {
                    coeficent = 14 * 1.2;
                } else if (problem == 3) {
                    coeficent = 15 * 1.2;
                } else if (problem == 4) {
                    coeficent = 16 * 1.2;
                }
                break;
        }
        double result = points * coeficent / 100;
        System.out.printf("Total points: %.2f", result);
    }
}
