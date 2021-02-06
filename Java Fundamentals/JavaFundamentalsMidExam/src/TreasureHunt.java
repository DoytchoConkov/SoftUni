import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> treasure = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"Yohoho!".equals(input)) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Loot":
                    for (int i = 1; i < token.length; i++) {
                        if (!treasure.contains(token[i])) {
                            treasure.add(0, token[i]);
                        }
                    }
                    break;
                case "Drop":
                    int indexDrop = Integer.parseInt(token[1]);
                    if (indexDrop >= 0 && indexDrop < treasure.size()) {
                        treasure.add(treasure.get(indexDrop));
                        treasure.remove(indexDrop);
                    }
                    break;
                case "Steal":
                    int stealCount = Integer.parseInt(token[1]);
                    int index = treasure.size() - stealCount;
                    int size=treasure.size();
                    if (index < 0) {
                        index = 0;
                    }
                    for (int i = index; i < size; i++) {
                        if (i == index) {
                            System.out.print(treasure.get(index));
                        } else {
                            System.out.print(", " + treasure.get(index));
                        }
                        treasure.remove(index);
                    }
                    System.out.println();
                    break;
            }
            input = scan.nextLine();
        }
        int sum = 0;
        int count = 0;
        for (String item : treasure) {
            sum = sum + item.length();
            count++;
        }
        if (count > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", 1.0 * sum / count);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
