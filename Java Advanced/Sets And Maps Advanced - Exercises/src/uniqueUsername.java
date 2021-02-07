import java.util.LinkedHashSet;
import java.util.Scanner;

public class uniqueUsername {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            usernames.add(input);
        }
        usernames.stream().forEach(e -> System.out.println(e));
    }
}
