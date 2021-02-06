import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputString = scan.nextLine().split("\\s+");
        List<String> array = new ArrayList<>();
        for (String text : inputString) {
            array.add(text);
        }
        String input = scan.nextLine();
        while (!"3:1".equals(input)) {
            String[] command = input.split("\\s+");
            if ("merge".equals(command[0])) {
                String temp = "";
                int startIndex = Integer.parseInt(command[1]);
                int EndIndex = Integer.parseInt(command[2]);
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (startIndex > array.size() - 1) {
                    startIndex = array.size() - 1;
                }
                if (EndIndex > array.size() - 1) {
                    EndIndex = array.size() - 1;
                }
                for (int i = startIndex; i <= EndIndex; i++) {
                    temp += array.get(startIndex);
                    array.remove(startIndex);
                }
                array.add(startIndex, temp);
            } else if ("divide".equals(command[0])) {
                int indexDivide = Integer.parseInt(command[1]);
                int parts = Integer.parseInt(command[2]);
                if (indexDivide >= 0 && indexDivide < array.size() && parts > 0) {
                    String temp = array.get(indexDivide);
                    array.remove(indexDivide);
                    int lenghtParts = temp.length() / parts;
                    int lastIndex = temp.length();
                    for (int i = 0; i < parts; i++) {
                        int startIndex = i * lenghtParts;
                        if (startIndex < 0) {
                            startIndex = 0;
                        }
                        int endIndex = startIndex + lenghtParts;
                        if (temp.length() % parts != 0) {
                            if (temp.length() - 1 - endIndex < lenghtParts) {
                                endIndex = temp.length();
                            }
                        }
                        String temp2 = temp.substring
                                (startIndex, endIndex);
                        array.add(indexDivide + i, temp2);
                    }
                }
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(" ", array));
    }
}
