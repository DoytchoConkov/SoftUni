import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scan.nextLine().split("!"))
                .collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"Go Shopping!".equals(input)) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Urgent":
                    if (!groceries.contains(command[1])) {
                        groceries.add(0, command[1]);
                    }
                    break;
                case "Unnecessary":
                    groceries.remove(command[1]);
                    break;
                case "Correct":
                    if (groceries.contains(command[1])) {
                        for (int i = 0; i < groceries.size(); i++) {
                            if (groceries.get(i).equals(command[1])) {
                                groceries.set(i, command[2]);
                            }
                        }
                    }
                    break;
                case "Rearrange":
                    if (groceries.contains(command[1])) {
                        groceries.remove(command[1]);
                        groceries.add(command[1]);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(", ", groceries));
    }
}
