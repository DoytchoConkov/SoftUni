import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> textAsList = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> checkerUpperCase =
                word -> Character.isUpperCase(word.charAt(0));

        ArrayList<String> result = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < textAsList.size(); i++) {
            if (checkerUpperCase.test(textAsList.get(i))) {
                result.add(textAsList.get(i));
                cnt++;
            }
        }

        System.out.println(cnt);
        result.forEach(System.out::println);
    }
}
