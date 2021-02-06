import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();
        String[] input = scan.nextLine().split(" ");
        for (String number : input) {
            numbers.add(Double.parseDouble(number));
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                double temp = numbers.get(i) * 2;
                numbers.set(i, temp);
                numbers.remove(i + 1);
                i=-1;
            }
        }
        String result = "";
        for (double number : numbers) {
            result += (new DecimalFormat("0.#").format(number) + " ");
        }
        System.out.println(result);
    }
}
