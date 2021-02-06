import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String codedText = scan.nextLine();
        String numbers = "";
        String text = "";
        for (int i = 0; i < codedText.length(); i++) {
            if (Character.isDigit(codedText.charAt(i))) {
                numbers = numbers + codedText.charAt(i);
            } else {
                text = text + codedText.charAt(i);
            }
        }
        String takeList = "";
        String skipList = "";
        for (int i = 0; i < numbers.length(); i++) {
            if (i % 2 != 0) {
                skipList = skipList + numbers.charAt(i);
            } else {
                takeList = takeList + numbers.charAt(i);
            }

        }
        String result = "";
        int index = 0;
        for (int i = 0; i < takeList.length(); i++) {
            int endSkip = Integer.parseInt("" + skipList.charAt(i));
            int end = Integer.parseInt("" + takeList.charAt(i));
            result = result + takeText(index, index+end, text);
            index = index + end + endSkip;
        }
        System.out.println(result);
    }

    public static String takeText(int start, int end, String text) {
        String temp = "";
        for (int i = start; i < end; i++) {
            temp = temp + text.charAt(i);
        }
        return temp;
    }
}
