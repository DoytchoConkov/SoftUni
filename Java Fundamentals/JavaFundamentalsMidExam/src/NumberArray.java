import java.util.Arrays;
import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Switch": {
                    int index = Integer.parseInt(token[1]);
                    if (index >= 0 && index < numbers.length) {
                        numbers[index] = -1 * numbers[index];
                    }
                }
                break;
                case "Change": {
                    int index = Integer.parseInt(token[1]);
                    if (index >= 0 && index < numbers.length) {
                        numbers[index] = Integer.parseInt(token[2]);
                    }
                }
                break;
                case "Sum": {
                    int sum = 0;
                    switch (token[1]) {
                        case "Negative":
                            for (int number : numbers) {
                                if (number < 0) {
                                    sum = sum + number;
                                }
                            }
                            System.out.println(sum);
                            break;
                        case "Positive":
                            for (int number : numbers) {
                                if (number >= 0) {
                                    sum = sum + number;
                                }
                            }
                            System.out.println(sum);
                            break;
                        case "All":
                            for (int number : numbers) {
                                sum = sum + number;
                            }
                            System.out.println(sum);
                            break;
                    }
                }
                break;
            }
            input = scan.nextLine();
        }
        for (int number : numbers) {
            if (number >= 0) {
                System.out.print(number + " ");
            }
        }
    }
}
