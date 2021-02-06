import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        String result ="";
        for (String word : words) {
            result+=repeatedWord(word);
        }
        System.out.println(result);
    }

    private static String repeatedWord(String word) {
        String temp="";
        for (int i = 0; i < word.length(); i++) {
            temp+=word;
        }
        return temp;
    }
}
