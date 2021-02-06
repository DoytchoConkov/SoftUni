import java.text.DecimalFormat;
import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] number = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(e -> Double.parseDouble(e)).toArray();
        TreeMap<Double, Integer> numbers = new TreeMap<>();

        for (int i = 0; i < number.length; i++) {
            numbers.putIfAbsent(number[i], 0);
            numbers.put(number[i], numbers.get(number[i]) + 1);
        }
        DecimalFormat df =new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> num : numbers.entrySet()) {
            System.out.printf("%s -> %d%n", df.format(num.getKey()), num.getValue());
        }
    }
}