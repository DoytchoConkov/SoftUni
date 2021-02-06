import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String [] text = input.split(" ");
        for (int i = text.length-1; i >=0 ; i--) {
            System.out.print(text[i]+" ");
        }
    }
}
