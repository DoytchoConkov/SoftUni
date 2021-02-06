import java.util.Scanner;

public class FriendlistMaintenance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] friends = scan.nextLine().split(", ");
        String input = scan.nextLine();
        int blaclistedNames = 0;
        int lostNames = 0;
        while (!"Report".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Blacklist":
                    int index = -1;
                    for (int i = 0; i < friends.length; i++) {
                        if (tokens[1].equals(friends[i])) {
                            index = i;
                            break;
                        }
                    }
                    if (index >= 0) {
                        System.out.printf("%s was blacklisted.%n", friends[index]);
                        friends[index] = "Blacklisted";
                        blaclistedNames++;
                    } else {
                        System.out.printf("%s was not found.%n", tokens[1]);
                    }
                    break;
                case "Error":
                    int indexError = Integer.parseInt(tokens[1]);
                    if (!("Blacklisted".equals(friends[indexError]) || "Lost".equals(friends[indexError]))) {
                        System.out.printf("%s was lost due to an error.%n", friends[indexError]);
                        friends[indexError] = "Lost";
                        lostNames++;
                    }

                    break;
                case "Change":
                    int indexForChange = Integer.parseInt(tokens[1]);
                    if (indexForChange >= 0 && indexForChange < friends.length) {
                        System.out.printf("%s changed his username to %s.%n", friends[indexForChange], tokens[2]);
                        friends[indexForChange] = tokens[2];
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", blaclistedNames);
        System.out.printf("Lost names: %d%n", lostNames);
        for (int i = 0; i < friends.length; i++) {
            System.out.printf("%s ", friends[i]);
        }
    }
}
