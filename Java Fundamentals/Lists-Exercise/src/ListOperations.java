import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        List<String> numbers = new ArrayList<>();
        for (String number : input) {
            numbers.add(number);
        }
        String command = scan.nextLine();
        while (!"End".equals(command)) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Add":
                    numbers.add(token[1]);
                    break;
                case "Insert":
                    int index = Integer.parseInt(token[2]);
                    if (index >= 0 && index <= numbers.size()) {
                        numbers.add(index, token[1]);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(token[1]);
                    if (removeIndex >= 0 && removeIndex < numbers.size()) {
                        numbers.remove(removeIndex);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    if ("left".equals(token[1])) {
                        for (int i = 0; i < Integer.parseInt(token[2]); i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }
                    } else if ("right".equals(token[1])) {
                        for (int i = 0; i < Integer.parseInt(token[2]); i++) {
                            numbers.add(0, numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(String.join(" ", numbers));
    }
}
