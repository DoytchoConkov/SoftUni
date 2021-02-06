import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int size = numbers.size();
        for (int i = 0; i < size / 2; i++) {
            int temp = numbers.get(i) + numbers.get(numbers.size() - 1);
            numbers.set(i, temp);
            numbers.remove(numbers.size() - 1);
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
