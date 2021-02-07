import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class setOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] sizes = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        for (int i = 0; i < sizes[0]; i++) {
            String input = scan.nextLine();
            set1.add(input);
        }
        for (int i = 0; i < sizes[1]; i++) {
            String input = scan.nextLine();
            set2.add(input);
        }
        for (String e : set1) {
            if (set2.contains(e)) System.out.print(e + " ");
        }
    }
}
