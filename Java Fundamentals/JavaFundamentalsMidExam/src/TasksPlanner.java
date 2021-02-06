import java.util.Arrays;
import java.util.Scanner;

public class TasksPlanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] tasks = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Complete": {
                    int index = Integer.parseInt(token[1]);
                    if (index >= 0 && index < tasks.length) {
                        tasks[index] = 0;
                    }
                }
                break;
                case "Change": {
                    int index = Integer.parseInt(token[1]);
                    if (index >= 0 && index < tasks.length) {
                        tasks[index] = Integer.parseInt(token[2]);
                    }
                }
                break;
                case "Drop": {
                    int index = Integer.parseInt(token[1]);
                    if (index >= 0 && index < tasks.length) {
                        tasks[index] = -1;
                    }
                }
                break;
                case "Count":
                    int counter = 0;
                    switch (token[1]) {
                        case "Completed":
                            for (int hours : tasks) {
                                if (hours == 0) {
                                    counter++;
                                }
                            }
                            System.out.println(counter);
                            break;
                        case "Incomplete":
                            for (int hours : tasks) {
                                if (hours > 0) {
                                    counter++;
                                }
                            }
                            System.out.println(counter);
                            break;
                        case "Dropped":
                            for (int hours : tasks) {
                                if (hours < 0) {
                                    counter++;
                                }
                            }
                            System.out.println(counter);
                            break;
                    }
                    break;
            }

            input = scan.nextLine();
        }
        for (int hours : tasks) {
            if (hours > 0) {
                System.out.print(hours + " ");
            }
        }
    }
}
