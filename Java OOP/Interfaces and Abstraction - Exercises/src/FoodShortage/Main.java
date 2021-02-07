package FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Buyer> buyers = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            if (token.length == 4) {
                buyers.putIfAbsent(token[0], new Citizen(token[0], Integer.parseInt(token[1]), token[2], token[3]));
            } else {
                buyers.putIfAbsent(token[0], new Rebel(token[0], Integer.parseInt(token[1]), token[2]));
            }
        }
        String input = scan.nextLine();
        while (!input.endsWith("End")) {
            if (buyers.containsKey(input)) {
                buyers.get(input).buyFood();
            }
            input = scan.nextLine();
        }
        int sum = 0;
        for (Buyer value : buyers.values()) {
            sum += value.getFood();
        }
        System.out.println(sum);
    }
}
