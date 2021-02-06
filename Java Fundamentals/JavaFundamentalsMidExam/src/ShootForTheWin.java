import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] targets = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int shootedTargets = 0;
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            int shootIndex = Integer.parseInt(input);
            if (shootIndex >= 0 && shootIndex < targets.length) {
                int value = targets[shootIndex];
                if (targets[shootIndex] != -1) {
                    targets[shootIndex] = -1;
                    shootedTargets++;
                    for (int i = 0; i < targets.length; i++) {
                        if (targets[i] > value) {
                            targets[i] = targets[i] - value;
                        } else {
                            if (targets[i] != -1) {
                                targets[i] = targets[i] + value;
                            }
                        }
                    }
                }
            }
            input = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",shootedTargets);
        for (int i = 0; i < targets.length; i++) {
            System.out.printf("%d ",targets[i]);
        }
    }
}
