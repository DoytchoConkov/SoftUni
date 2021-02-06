import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        printCharecter(text);
    }

    private static void printCharecter(String text) {
        int middle=text.length()/2;
        if (text.length()%2==0){
            System.out.printf("%c",text.charAt(middle-1));
        }
        System.out.printf("%c",text.charAt(middle));
    }
}
