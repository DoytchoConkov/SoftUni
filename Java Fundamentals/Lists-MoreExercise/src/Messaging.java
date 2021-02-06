import java.util.Scanner;

public class Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] positionIntext = scan.nextLine().split(" ");
        Integer[] position = new Integer[positionIntext.length];
        for (int i = 0; i < positionIntext.length; i++) {
            position[i] = Integer.parseInt(positionIntext[i]);
        }
        String text = scan.nextLine();
        for (int i = 0; i < position.length; i++) {
            int index = getindex(position[i]);
            if (index > text.length()) {
                index = index % (text.length());
            }
            System.out.printf("%c", text.charAt(index));
            String temp = "";
            for (int j = 0; j < text.length(); j++) {
                if (j != index) {
                    temp = temp + text.charAt(j);
                }
            }
            text = temp;
        }
    }

    private static int getindex(Integer number) {
        int sum = 0;
        while (number > 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }
}
