import java.util.Scanner;

public class E09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h1 = Integer.parseInt(scan.nextLine());
        int m1 = Integer.parseInt(scan.nextLine());
        int h2 = Integer.parseInt(scan.nextLine());
        int m2 = Integer.parseInt(scan.nextLine());
        int timeExam = h1 * 60 + m1;
        int timeArive = h2 * 60 + m2;

        if (timeExam - timeArive < 0) {
            System.out.println("Late");
        } else if (timeExam - timeArive < 30) {
            System.out.println("On time");
        } else {
            System.out.println("Early");
        }
        int difrence = timeExam - timeArive;
        if (difrence < -60) {
            System.out.printf("%d:%02d hours after the start", Math.abs(difrence / 60), Math.abs(difrence % 60));
        } else if (difrence < 0) {
            System.out.printf("%d minutes after the start", Math.abs(difrence));
        } else if (difrence > 0 && difrence < 60) {
            System.out.printf("%d minutes before the start", difrence);
        } else if (difrence >= 60) {
            System.out.printf("%d:%02d hours before the start", difrence / 60, difrence % 60);
        }
    }
}
