import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = java.lang.Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int battles = 0;
        int cnt = 0;
        while (!"End of battle".equals(input)) {
            int distance = Integer.parseInt(input);

            if (energy < distance) {
                break;
            }
            energy = energy - distance;
            input = scan.nextLine();
            battles++;
            cnt++;
            if (cnt == 3) {
                energy = energy + battles;
                cnt = 0;
            }
        }
        if ("End of battle".equals(input)) {
            System.out.printf("Won battles: %d. Energy left: %d", battles, energy);
        } else {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battles, energy);
        }
    }
}
