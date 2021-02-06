import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> journal = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"Craft!".equals(input)) {
            String[] token = input.split(" - ");
            switch (token[0]) {
                case "Collect":
                    if (!journal.contains(token[1])) {
                        journal.add(token[1]);
                    }
                    break;
                case "Drop":
                    journal.remove(token[1]);
                    break;
                case "Combine Items":
                    String[] ithems = token[1].split(":");
                    for (int i = 0; i < journal.size(); i++) {
                        if (journal.get(i).equals(ithems[0])) {
                            journal.add(i + 1, ithems[1]);
                        }
                    }
                    break;
                case "Renew":
                    if (journal.contains(token[1])) {
                        journal.remove(token[1]);
                        journal.add(token[1]);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println(journal.toString().replaceAll("[\\[\\]]", ""));
    }
}
