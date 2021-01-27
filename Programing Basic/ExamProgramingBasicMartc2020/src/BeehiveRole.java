import java.util.Scanner;

public class BeehiveRole {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int intelect = Integer.parseInt(scan.nextLine());
        int power = Integer.parseInt(scan.nextLine());
        String sex = scan.nextLine();
        String beeType = "";
        if (intelect >= 80 && power >= 80 && "female".equals(sex)) {
            beeType = "Queen Bee";
        } else if (intelect >= 80) {
            beeType = "Repairing Bee";
        } else if (intelect >= 60) {
            beeType = "Cleaning Bee";
        } else if (power >= 80 && "male".equals(sex)) {
            beeType = "Drone Bee";
        } else if (power >= 60) {
            beeType = "Guard Bee";
        } else {
            beeType = "Worker Bee";
        }
        System.out.println(beeType);
    }
}
