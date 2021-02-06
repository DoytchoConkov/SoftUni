import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        String text = "";
        for (int i = 0; i < n; i++) {
            char input = scan.nextLine().charAt(0);
            int number = input + key;
            text = text+String.format("%c", number);
        }
        System.out.println(text);
    }
}
