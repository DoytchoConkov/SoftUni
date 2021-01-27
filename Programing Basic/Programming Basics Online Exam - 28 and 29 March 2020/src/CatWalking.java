import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int minutesWal = Integer.parseInt(scan.nextLine());
        int countWalk = Integer.parseInt(scan.nextLine());
        int calories = Integer.parseInt(scan.nextLine());
        int totalTimeWalk = minutesWal * countWalk;
        int burnCalories = totalTimeWalk * 5;
        if (burnCalories * 2 >= calories) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", burnCalories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", burnCalories);
        }
    }
}
