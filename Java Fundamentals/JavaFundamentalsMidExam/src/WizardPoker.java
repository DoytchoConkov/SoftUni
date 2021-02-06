import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WizardPoker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> allCards = Arrays.stream(scan.nextLine().split(":"))
                .collect(Collectors.toList());
        List<String> desk = new ArrayList<>();
        String input = scan.nextLine();
        while (!"Ready".equals(input)) {
            String[] token = input.split(" ");
            switch (token[0]) {
                case "Add":
                    if (allCards.contains(token[1])) {
                        desk.add(token[1]);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    int inserIndex = Integer.parseInt(token[2]);
                    if (inserIndex >= 0 && inserIndex < desk.size() && allCards.contains(token[1])) {
                        desk.add(inserIndex, token[1]);
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    if (desk.contains(token[1])) {
                        desk.remove(token[1]);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0; i < desk.size(); i++) {
                        if (desk.get(i).equals(token[1])) {
                            index1 = i;
                        }
                        if (desk.get(i).equals(token[2])) {
                            index2 = i;
                        }
                    }
                    desk.set(index1, token[2]);
                    desk.set(index2, token[1]);
                    break;
                case "Shuffle":
                    for (int i = 0; i < desk.size() / 2; i++) {
                        String temp = desk.get(i);
                        desk.set(i, desk.get(desk.size() - 1 - i));
                        desk.set(desk.size() - 1 - i, temp);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (String card : desk) {
            System.out.print(card + " ");
        }
    }
}
