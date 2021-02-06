import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int element = 0;
        int maxLenght = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            int counter = 0;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    counter++;
                }else {
                    break;
                }
            }
            if (counter > maxLenght) {
                element = numbers[i];
                maxLenght=counter;
            }
        }
        for (int i = 0; i < maxLenght; i++) {
            System.out.print(element + " ");
        }
    }
}
