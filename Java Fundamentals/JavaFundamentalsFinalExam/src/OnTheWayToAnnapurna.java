import java.util.*;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> stores = new HashMap<>();
        while (!"END".equals(input)) {
            String[] tokens = input.split("->");
            String store = tokens[1];
            switch (tokens[0]) {
                case "Add":
                    String[] ithems = tokens[2].split(",");
                    stores.putIfAbsent(store, new ArrayList<>());
                    for (int i = 0; i < ithems.length; i++) {
                        stores.get(store).add(ithems[i]);
                    }
                    break;
                case "Remove":
                    if (stores.containsKey(store)) {
                        stores.remove(store);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Stores list:");
        stores
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int result = e2.getValue().size() - e1.getValue().size();
                    if (result == 0) {
                        result = e2.getKey().compareTo(e1.getKey());
                    }
                    return result;
                }).forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().stream().forEach(ithem -> {
                System.out.printf("<<%s>>%n", ithem);
            });
        });
    }
}
