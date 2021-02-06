import java.util.Arrays;
import java.util.Scanner;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] targets = Arrays.stream(scan.nextLine().split("\\|"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int points = 0;
        String input = scan.nextLine();
        while (!"Game over".equals(input)) {
            String[] tokens = input.split("\\@");
            int targetIndex = 0;
            switch (tokens[0]) {
                case "Shoot Left": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int distance = Integer.parseInt(tokens[2]);
                    if (inrange(targets, startIndex)) {
                        targetIndex = startIndex - distance;
                        while(targetIndex<0){
                            targetIndex+=targets.length;
                        }
                        if (targets[targetIndex] > 5) {
                            points += 5;
                            targets[targetIndex] -= 5;
                        } else {
                            points += targets[targetIndex];
                            targets[targetIndex] = 0;
                        }
                    }
                }
                break;
                case "Shoot Right": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int distance = Integer.parseInt(tokens[2]);
                    if (inrange(targets, startIndex)) {
                        targetIndex = startIndex + distance;
                        while(targetIndex>targets.length-1){
                            targetIndex-=targets.length;
                        }
                        if (targets[targetIndex] > 5) {
                            points += 5;
                            targets[targetIndex] -= 5;
                        } else {
                            points += targets[targetIndex];
                            targets[targetIndex] = 0;
                        }
                    }
                }
                break;
                case "Reverse":
                    for (int i = 0; i < targets.length / 2; i++) {
                        int temp = targets[i];
                        targets[i] = targets[targets.length - i - 1];
                        targets[targets.length - i - 1] = temp;
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < targets.length; i++) {
            if (i == 0) {
                System.out.print(targets[0]);
            } else {
                System.out.printf(" - %d", targets[i]);
            }
        }
        System.out.println();
        System.out.printf("Iskren finished the archery tournament with %d points!%n", points);
    }

    private static boolean inrange(int[] targets, int startIndex) {
        return startIndex >= 0 && startIndex < targets.length;
    }
}
