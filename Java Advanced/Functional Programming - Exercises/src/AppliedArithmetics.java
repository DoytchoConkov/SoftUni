import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Map<String, Function<List<Integer>, List<Integer>>> func = new LinkedHashMap<>();
        func.put("add", e -> e.stream().map(num -> num + 1).collect(Collectors.toList()));
        func.put("multiply", e -> e.stream().map(num -> num * 2).collect(Collectors.toList()));
        func.put("subtract", e -> e.stream().map(num -> num - 1).collect(Collectors.toList()));
        func.put("print", e -> e.stream().peek(num -> System.out.print(num + " ")).collect(Collectors.toList()));

        String input = scan.nextLine();
        while (!input.equals("end")) {
            numbers = func.get(input).apply(numbers);
            input = scan.nextLine();
        }

    }
}
