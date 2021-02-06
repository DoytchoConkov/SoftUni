import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(java.lang.System.in);
        int students = java.lang.Integer.parseInt(scan.nextLine());
        int courseLectures = java.lang.Integer.parseInt(scan.nextLine());
        int bonus = java.lang.Integer.parseInt(scan.nextLine());
        double maxBonus = 0;
        int maxAttaches = 0;
        for (int i = 0; i < students; i++) {
            int studentAtaches = Integer.parseInt(scan.nextLine());
            double temp = 1.0 * studentAtaches / courseLectures * (5 + bonus);
            if (temp > maxBonus) {
                maxBonus = temp;
                maxAttaches = studentAtaches;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttaches);
    }
}
