import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split("\\s+");
            if ("Delete".equals(command[0])) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (Integer.parseInt(command[1]) == numbers.get(i)) {
                        numbers.remove(i);
                        i--;
                    }
                }
            } else if ("Insert".equals(command[0])) {
                int index = Integer.parseInt(command[2]);
                if (index >= 0 && index < numbers.size()) {
                    numbers.add(index, Integer.parseInt(command[1]));
                }
            }
            input = scan.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
