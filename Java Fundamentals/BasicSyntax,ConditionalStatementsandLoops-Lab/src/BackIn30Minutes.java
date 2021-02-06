import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());
        int totalMinutes = hours * 60 + minutes + 30;
        int hoursCalculated = totalMinutes / 60;
        int minutesCalculated = totalMinutes % 60;
        if (hoursCalculated > 23) {
            hoursCalculated = hoursCalculated - 24;
        }
        String note = String.format("%d:%02d", hoursCalculated, minutesCalculated);
        System.out.println(note);
    }
}
