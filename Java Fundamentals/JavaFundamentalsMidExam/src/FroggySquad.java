import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FroggySquad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> frogs = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());
        String input = scan.nextLine();
        String[] token = input.split("\\s+");
        while (!"Print".equals(token[0])) {
            switch (token[0]) {
                case "Join":
                    if (!frogs.contains(token[1])) {
                        frogs.add(token[1]);
                    }
                    break;
                case "Jump":
                    int indexJump = Integer.parseInt(token[2]);
                    if (indexJump >= 0 && indexJump <= frogs.size()) {
                        frogs.add(indexJump, token[1]);
                    }
                    break;
                case "Dive":
                    int indexDrop = Integer.parseInt(token[1]);
                    if (indexDrop >= 0 && indexDrop < frogs.size()) {
                        frogs.remove(indexDrop);
                    }
                    break;
                case "First": {
                    int counter = Integer.parseInt(token[1]);
                    if (counter > frogs.size()) {
                        counter = frogs.size() ;
                    }
                    for (int i = 0; i < counter; i++) {
                        System.out.print(frogs.get(i) + " ");
                    }
                    System.out.println();
                }
                break;
                case "Last": {
                    int counter = Integer.parseInt(token[1]);
                    if (counter >= frogs.size()) {
                        counter = frogs.size() ;
                    }
                    for (int i = frogs.size() - counter; i < frogs.size(); i++) {
                        System.out.print(frogs.get(i) + " ");
                    }
                    System.out.println();
                }
                break;
            }
            token = scan.nextLine().split("\\s+");
        }
        if (token[1].equals("Normal")) {
            System.out.print("Frogs: ");
            for (String frog : frogs) {
                System.out.print(frog + " ");
            }
        } else if (token[1].equals("Reversed")) {
            System.out.print("Frogs: ");
            for (int i = frogs.size() - 1; i >= 0; i--) {
                System.out.print(frogs.get(i) + " ");
            }
        }
    }
}
