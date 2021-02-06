import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> shops = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            switch (token[0]) {
                case "Include":
                    shops.add(token[1]);
                    break;
                case "Visit":
                    int lenght = Integer.parseInt(token[2]);
                    if (lenght <= shops.size()) {
                        if (token[1].equals("first")) {
                            for (int j = 0; j < lenght; j++) {
                                shops.remove(0);
                            }
                        } else if (token[1].equals("last")) {
                            int position=shops.size() - lenght;
                            for (int j = 0; j < lenght; j++) {
                                shops.remove(position);
                            }
                        }
                    }
                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(token[1]);
                    int index2 = Integer.parseInt(token[2]);
                    if (index1 >= 0 && index1 < shops.size() && index2 >= 0 && index2 < shops.size()) {
                        String temp = shops.get(index1);
                        shops.set(index1, shops.get(index2));
                        shops.set(index2, temp);
                    }
                    break;
                case "Place":
                    int index = Integer.parseInt(token[2])+1;
                    if (index >= 0 && index <= shops.size()) {
                        shops.add(index, token[1]);
                    }
                    break;
            }
        }
        System.out.println("Shops left:");
        for (String shop : shops) {
            System.out.print(shop + " ");
        }
    }
}
