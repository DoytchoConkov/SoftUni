import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!"End".equals(input)) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "Shoot": {
                    int index = Integer.parseInt(command[1]);
                    if (index >= 0 && index < targets.size()) {
                        targets.set(index, targets.get(index) - Integer.parseInt(command[2]));
                        if (targets.get(index) <= 0) {
                            targets.remove(index);
                        }
                    }
                }
                break;

                case "Add": {
                    int index = Integer.parseInt(command[1]);
                    if (index >= 0 && index < targets.size()) {
                        targets.add(index, Integer.parseInt(command[2]));
                    } else {
                        System.out.println("Invalid placement!");
                    }
                }

                break;
                case "Strike": {
                    int index = Integer.parseInt(command[1]);
                    int radius = Integer.parseInt(command[2]);
                    if (index - radius >= 0 && index + radius < targets.size()) {
                        for (int i = 0; i < 1 + radius + radius; i++) {
                            targets.remove(index - radius);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                }
                break;
            }

            input = scan.nextLine();
        }

        for (int i = 0; i < targets.size(); i++) {
            if (i == 0) {
                System.out.printf("%d", targets.get(i));
            } else {
                System.out.printf("|%d", targets.get(i));
            }
        }
    }
}
