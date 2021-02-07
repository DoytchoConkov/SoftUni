import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> phonebook = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("search")) {
            String[] token = input.split("-");
            phonebook.put(token[0], token[1]);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s\n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }
            input = scan.nextLine();
        }
    }
}
