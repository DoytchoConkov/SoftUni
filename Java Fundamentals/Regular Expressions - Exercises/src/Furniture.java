import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println("Bought furniture:");
        Pattern pattern = Pattern.compile(">>(?<ithem>[A-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)");
        double totalPrice = 0.0;
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println(matcher.group("ithem"));
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalPrice += price * quantity;
            }
            input = scan.nextLine();
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
