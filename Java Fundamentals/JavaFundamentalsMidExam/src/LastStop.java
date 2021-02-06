import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastStop {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> colors = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Change":
                    for (int i = 0; i < colors.size(); i++) {
                        if (colors.get(i).equals(tokens[1])) {
                            colors.set(i, tokens[2]);
                            break;
                        }
                    }
                    break;
                case "Hide":
                    colors.remove(tokens[1]);
                    break;
                case "Switch":
                    int index1 = -1;
                    int index2 = -1;
                    for (int i = 0; i < colors.size(); i++) {
                        if (colors.get(i).equals(tokens[1])) {
                            index1 = i;
                        }
                        if (colors.get(i).equals(tokens[2])) {
                            index2 = i;
                        }
                    }
                    if (index1 >= 0 && index2 >= 0) {
                        String temp = colors.get(index1);
                        colors.set(index1, colors.get(index2));
                        colors.set(index2, temp);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]) + 1;
                    if (index >= 0 && index <= colors.size()) {
                        colors.add(index, tokens[2]);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(colors);
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println(colors.toString().replaceAll("[\\[\\],]", ""));
    }
}
