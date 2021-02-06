import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        vowelCounter(text.toLowerCase());
    }

    private static void vowelCounter(String text) {

        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'a':
                case 'e':
                case 'o':
                case 'u':
                case 'i':
                    counter++;
                    break;
            }
        }
        System.out.println(counter);
    }
}
