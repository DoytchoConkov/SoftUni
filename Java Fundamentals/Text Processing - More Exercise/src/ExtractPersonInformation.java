import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            int nameStartPosition = input.indexOf('@') + 1;
            int nameEndPosition = input.indexOf('|');
            int ageStartPosition = input.indexOf('#') + 1;
            int ageEndPosition = input.indexOf('*');
            String name = input.substring(nameStartPosition, nameEndPosition);
            String age = input.substring(ageStartPosition, ageEndPosition);
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
