package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomList<String> customList = new CustomList<String>();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    System.out.println(customList.remove(Integer.parseInt(tokens[1])));
                    break;
                case "Contains":
                    System.out.println(customList.contains(tokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
            }

            input = scan.nextLine();
        }
    }
}
