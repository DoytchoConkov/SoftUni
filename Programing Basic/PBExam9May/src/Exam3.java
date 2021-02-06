import java.util.Scanner;

public class Exam3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dificult = Integer.parseInt(scan.nextLine());
        int twisted = Integer.parseInt(scan.nextLine());
        int pages = Integer.parseInt(scan.nextLine());
        String text = "";
        if (dificult >= 80 && twisted >= 80 && pages >= 8) {
            text = "Legacy";
        } else if (dificult >= 80 && twisted <= 10) {
            text = "Master";
        } else if (twisted >= 50 && pages >= 2) {
            text = "Hard";
        } else if (dificult <= 30 && pages >= 1) {
            text = "Easy";
        } else if (dificult <= 10) {
            text = "Elementary";
        } else {
            text = "Regular";
        }
        System.out.println(text);
    }
}
