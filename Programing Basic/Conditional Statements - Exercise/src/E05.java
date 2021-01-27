import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());
        minutes = minutes + 15;
        if (minutes > 59) {
            minutes = minutes - 60;
            hours++;
            if (hours > 23) {
                hours = 0;
            }
        }
        System.out.printf("%d:%02d", hours, minutes);
    }
}
