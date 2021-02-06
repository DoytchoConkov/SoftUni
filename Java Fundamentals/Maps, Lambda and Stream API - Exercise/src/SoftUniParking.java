import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> parking = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            if (token[0].equals("register")) {
                if (parking.containsKey(token[1])) {
                    System.out.printf("ERROR: already registered with plate number %s%n", token[2]);
                } else {
                    System.out.printf("%s registered %s successfully%n", token[1], token[2]);
                    parking.put(token[1], token[2]);
                }
            } else {
                if (parking.containsKey(token[1])) {
                    System.out.printf("%s unregistered successfully%n", token[1]);
                    parking.remove(token[1]);
                } else {
                    System.out.printf("ERROR: user %s not found%n", token[1]);
                }
            }
        }
        parking
                .forEach((k, v) -> {
                    System.out.printf("%s => %s%n", k, v);
                });
    }
}
