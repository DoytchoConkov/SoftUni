import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] text = input.split(" ");
        input = scan.nextLine();
        String[] text2 = input.split(" ");
        String equalsElements = "";
        for (int i = 0; i < text2.length; i++) {
            for (int j = 0; j < text.length; j++) {
                if (text[j].equals(text2[i])) {
                    equalsElements = equalsElements + text2[i] + " ";
                }
            }
        }
        System.out.println(equalsElements);
    }
}
