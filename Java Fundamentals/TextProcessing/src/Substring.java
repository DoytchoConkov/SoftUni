import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String filter = scan.nextLine();
        String text = scan.nextLine();
        while (text.contains(filter)) {
            text = text.replace( filter,"");
        }
        System.out.println(text);
    }
}
