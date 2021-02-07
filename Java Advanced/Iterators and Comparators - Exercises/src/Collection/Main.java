package Collection;


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
                    System.out.println(listIterator.next());
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "Print":
                    System.out.print(listIterator.print() + " ");
                    System.out.println();
                    break;
                case "PrintAll":
                    for (String element : listIterator) {
                        System.out.print(element+" ");
                    }
                    System.out.println();
                    break;
            }
            input = scan.nextLine();
        }
    }
}
