import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class countRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] numbersArray = Arrays.stream(scan.nextLine().split(" "))
                .mapToDouble(e -> Double.parseDouble(e)).toArray();

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap();
        for (double number : numbersArray) {
            numbers.putIfAbsent(number, 0);
            numbers.put(number, numbers.get(number) + 1);
        }

        numbers.entrySet().stream().forEach(e -> System.out.printf("%.1f -> %d%n", e.getKey(), e.getValue()));
    }
}
