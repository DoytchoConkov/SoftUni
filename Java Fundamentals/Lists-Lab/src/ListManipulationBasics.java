import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(Integer.parseInt(command[1])));
                    break;
                case "RemoveAt":
                    numbers.remove(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
