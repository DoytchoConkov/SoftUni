import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
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
                case "Contains":
                    if (numbers.contains(Integer.valueOf(command[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if ("even".equals(command[1])) {
                        for (int number : numbers) {
                            if (number % 2 == 0) {
                                System.out.print(number + " ");
                            }
                        }
                    } else {
                        for (int number : numbers) {
                            if (number % 2 != 0) {
                                System.out.print(number + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    for (int number : numbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    switch (command[1]) {
                        case "<":
                            for (int number : numbers) {
                                if (number < Integer.parseInt(command[2])) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (int number : numbers) {
                                if (number > Integer.parseInt(command[2])) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int number : numbers) {
                                if (number <= Integer.parseInt(command[2])) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (int number : numbers) {
                                if (number >= Integer.parseInt(command[2])) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
            input = scan.nextLine();
        }
    }
}