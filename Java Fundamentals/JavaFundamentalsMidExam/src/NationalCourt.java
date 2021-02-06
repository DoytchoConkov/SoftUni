import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int emploer1 = Integer.parseInt(scan.nextLine());
        int emploer2 = Integer.parseInt(scan.nextLine());
        int emploer3 = Integer.parseInt(scan.nextLine());
        int peoples = Integer.parseInt(scan.nextLine());
        int totalPeoplePerHour = emploer1 + emploer2 + emploer3;
        int totalTime = peoples / totalPeoplePerHour;
        if (peoples % totalPeoplePerHour != 0) {
            totalTime++;
        }
        if (totalTime % 3 == 0) {
            totalTime = totalTime + totalTime / 3 - 1;
            if (totalTime < 0) {
                totalTime = 0;
            }
        } else {
            totalTime = totalTime + totalTime / 3;
        }
        System.out.printf("Time needed: %dh.", totalTime);
    }
}
