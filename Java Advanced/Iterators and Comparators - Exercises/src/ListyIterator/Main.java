package ListyIterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strings = Arrays.stream(scan.nextLine().split("\\s+"))
                .skip(1)
                .toArray(String[]::new);

        ListyIterator listIterator = new ListyIterator(strings);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            switch (input) {
                case "Move":
                    System.out.println(listIterator.move());;
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "Print":
                    System.out.println(listIterator.print());
                    break;
            }
            input = scan.nextLine();
        }
    }
}
