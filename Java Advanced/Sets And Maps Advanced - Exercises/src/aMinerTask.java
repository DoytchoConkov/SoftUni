import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> miner = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());
            miner.putIfAbsent(input, 0);
            miner.put(input, miner.get(input) + quantity);
            input = scan.nextLine();
        }
        miner.entrySet().stream().forEach(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));
    }
}
