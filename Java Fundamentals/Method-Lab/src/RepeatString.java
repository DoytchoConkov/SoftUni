import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int cnt = Integer.parseInt(scan.nextLine());
        System.out.println(stringRepeater(text, cnt));
    }

    public static String stringRepeater(String input, int n) {
        String output="";
        for (int i = 0; i < n; i++) {
            output += input;
        }
        return output;
    }
}
