import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String imput = scan.nextLine();
        boolean flagC = false;
        boolean flagO = false;
        boolean flagN = false;
        String text = "";
        while (!imput.equals("End")) {
            char letter = imput.charAt(0);
            if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
                if (letter == 'c' && !flagC) {
                    flagC = true;
                    if (flagC && flagO && flagN) {
                        text = text + " ";
                        flagC = false;
                        flagN = false;
                        flagO = false;
                    }
                } else if (letter == 'o' && !flagO) {
                    flagO = true;
                    if (flagC && flagO && flagN) {
                        text = text + " ";
                        flagC = false;
                        flagN = false;
                        flagO = false;
                    }
                } else if (letter == 'n' && !flagN) {
                    flagN = true;
                    if (flagC && flagO && flagN) {
                        text = text + " ";
                        System.out.print(text);
                        text = "";
                        flagC = false;
                        flagN = false;
                        flagO = false;
                    }
                } else {
                    text = text + letter;
                }
            }
            imput = scan.nextLine();
        }

    }
}
