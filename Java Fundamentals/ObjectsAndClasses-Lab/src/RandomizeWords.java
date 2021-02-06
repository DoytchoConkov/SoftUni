import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split("\\s+");
        Random rnd = new Random();
        for (int i = 0; i < text.length; i++) {
            int n = rnd.nextInt(text.length);
            String temp = text[i];
            text[i] = text[n];
            text[n] = temp;
        }
        for (String txt : text) {
            System.out.println(txt);
        }
    }
}
