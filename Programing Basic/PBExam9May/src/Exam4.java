import java.util.Scanner;

public class Exam4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double students = Double.parseDouble(scan.nextLine());
        int seasons = Integer.parseInt(scan.nextLine());
        int counter = 1;
        for (int i = 0; i < seasons; i++) {
            students = Math.ceil(students * 0.9);
            students = Math.ceil(students * 0.9);
            students = Math.ceil(students * 0.8);
            counter++;
            if (counter == 4) {
                students = students + Math.ceil(students * 0.15);
                counter = 1;
            } else {
                students = students + Math.ceil(students * 0.05);
            }
        }
        System.out.printf("Students: %.0f", students);
    }
}
