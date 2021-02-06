import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> contacts = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scan.nextLine();
        String[] token = input.split("\\s+");
        while (!"Print".equals(token[0])) {
            switch (token[0]) {
                case "Add":
                    int index = Integer.parseInt(token[2]);
                    if (contacts.contains(token[1])) {
                        if (index >= 0 && index < contacts.size()) {
                            contacts.add(index, token[1]);
                        }
                    } else {
                        contacts.add(token[1]);
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(token[1]);
                    if (removeIndex >= 0 && removeIndex < contacts.size()) {
                        contacts.remove(removeIndex);
                    }
                    break;
                case "Export":
                    int startIndex = Integer.parseInt(token[1]);
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    int cnt = Integer.parseInt(token[2]);
                    int endIndex = startIndex + cnt-1;
                    if (endIndex > contacts.size()-1) {
                        endIndex = contacts.size() - 1;
                    }
                    for (int i = startIndex; i <= endIndex; i++) {
                        System.out.print(contacts.get(i) + " ");
                    }
                    System.out.println();
                    break;
            }
            token = scan.nextLine().split("\\s+");
        }
        System.out.print("Contacts: ");
        if ("Normal".equals(token[1])) {
            for (String contact : contacts) {
                System.out.print(contact + " ");
            }
        } else if ("Reversed".equals(token[1])) {
            for (int i = contacts.size() - 1; i >= 0; i--) {
                System.out.print(contacts.get(i) + " ");
            }
        }
    }
}
