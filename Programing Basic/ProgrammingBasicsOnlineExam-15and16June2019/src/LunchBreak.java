import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String serialName = scan.nextLine();
        int episodeDuration = Integer.parseInt(scan.nextLine());
        int relaxDuration = Integer.parseInt(scan.nextLine());
        if (1.0 * episodeDuration <= relaxDuration * 5.0 / 8.0) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",
                    serialName, Math.ceil(relaxDuration * 5.0 / 8.0 - episodeDuration));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",
                    serialName, Math.ceil(episodeDuration - relaxDuration * 5.0 / 8.0));
        }
    }
}
