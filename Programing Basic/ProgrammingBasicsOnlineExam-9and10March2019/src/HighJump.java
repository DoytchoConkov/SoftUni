import java.util.Scanner;

public class HighJump {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wantedHight = Integer.parseInt(scan.nextLine());
        int startingHight = wantedHight - 30;
        int counter = 0;
        int flagLose = 0;
        int currentHight = 0;
        while (wantedHight > currentHight) {
            currentHight = Integer.parseInt(scan.nextLine());
            counter++;
            if (currentHight <= startingHight) {
                flagLose++;
            } else {
                startingHight = startingHight + 5;
                flagLose = 0;
            }
            if (flagLose == 3) {
                break;
            }
        }
        if (flagLose == 3) {
            System.out.printf("Tihomir failed at %dcm after %d jumps.", startingHight, counter);
        } else {
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.",wantedHight,counter);
        }

    }
}
