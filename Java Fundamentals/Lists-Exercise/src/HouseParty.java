import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> guests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split("\\s+", 2);
            String name = command[0];
            switch (command[1]) {
                case "is going!":
                    if (guests.contains(command[0])) {
                        System.out.printf("%s is already in the list!%n", name);
                    } else {
                        guests.add(name);
                    }
                    break;
                case "is not going!":
                    if (!guests.contains(name)) {
                        System.out.printf("%s is not in the list!%n", name);
                    } else {
                        guests.remove(name);
                    }
                    break;
            }
        }
        for (String name : guests) {
            System.out.println(name);
        }
    }
}
