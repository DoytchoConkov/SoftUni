import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputString = scan.nextLine().split(", ");
        List<String> array = new ArrayList<>();
        for (String text : inputString) {
            array.add(text);
        }
        String input = scan.nextLine();
        while (!"course start".equals(input)) {
            String[] commands = input.split(":");
            switch (commands[0]) {
                case "Add":
                    if (!array.contains(commands[1])) {
                        array.add(commands[1]);
                    }
                    break;
                case "Insert":
                    if (!array.contains(commands[1])) {
                        array.add(Integer.parseInt(commands[2]), commands[1]);
                    }
                    break;
                case "Remove":
                    if (array.contains(commands[1])) {
                        array.remove(commands[1]);
                        array.remove(commands[1] + "-Exercise");
                    }
                    break;
                case "Swap":
                    if (array.contains(commands[1]) && array.contains(commands[2])) {
                        int index1 = array.indexOf(commands[1]);
                        int index2 = array.indexOf(commands[2]);
                        array.set(index1, commands[2]);
                        array.set(index2, commands[1]);
                        if (array.contains(commands[1] + "-Exercise")) {
                            int index3 = array.indexOf(commands[1] + "-Exercise");
                            array.remove(index3);
                            array.add(index2 + 1, commands[1] + "-Exercise");
                        }
                        if (array.contains(commands[2] + "-Exercise")) {
                            int index4 = array.indexOf(commands[2] + "-Exercise");
                            array.remove(index4);
                            array.add(index1 + 1, commands[2] + "-Exercise");
                        }
                    }
                    break;
                case "Exercise":
                    if (array.contains(commands[1]) && !array.contains(commands[1] + "-Exercise")) {
                        int index = array.indexOf(commands[1]) + 1;
                        array.add(index, commands[1] + "-Exercise");
                    } else if (!array.contains(commands[1])&& !array.contains(commands[1] + "-Exercise")) {
                        array.add(commands[1]);
                        array.add(commands[1] + "-Exercise");
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (
                int i = 0; i < array.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, array.get(i));
        }
    }
}
