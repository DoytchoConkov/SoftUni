import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arrays = scan.nextLine().split("\\|");
        List<String> numbers = new ArrayList<>();
        for (int i = arrays.length-1; i >= 0; i--) {
            String[] arr = arrays[i].trim().split("\\s+");
            for (String number : arr) {
                numbers.add(number);
            }
            numbers.remove("");
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
