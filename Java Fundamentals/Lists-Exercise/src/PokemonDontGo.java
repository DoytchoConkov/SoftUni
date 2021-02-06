import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String in : input) {
            numbers.add(Integer.parseInt(in));
        }
        int sum = 0;
        while (numbers.size() > 0) {
            int n = Integer.parseInt(scan.nextLine());
            int temp = 0;
            if (n < 0) {
                n = 0;
                temp = numbers.get(n);
                sum += temp;
                numbers.remove(n);
                numbers.add(n, numbers.get(numbers.size() - 1));
            } else if (n > numbers.size()-1)  {
                n = numbers.size() - 1;
                temp = numbers.get(n);
                sum += temp;
                numbers.remove(n);
                numbers.add(n, numbers.get(0));
            } else {
                temp = numbers.get(n);
                sum += temp;
                numbers.remove(n);
            }
            for (int i = 0; i < numbers.size(); i++) {
                if (temp >= numbers.get(i)) {
                    numbers.set(i, numbers.get(i) + temp);
                } else {
                    numbers.set(i, numbers.get(i) - temp);
                }
            }
        }
        System.out.println(sum);
    }
}
