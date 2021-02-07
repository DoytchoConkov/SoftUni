import java.util.Scanner;
import java.util.TreeSet;

public class softUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeSet<String> vips = new TreeSet<>();
        TreeSet<String> redgular = new TreeSet<>();
        String input = scan.nextLine();

        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(7))) {
                vips.add(input);
            } else {
                redgular.add(input);
            }
            input = scan.nextLine();

        }

        input = scan.nextLine();

        while (!input.equals("END")) {
            vips.remove(input);
            redgular.remove(input);
            input = scan.nextLine();

        }

        System.out.println(vips.size() + redgular.size());
        vips.stream().forEach(e -> System.out.println(e));
        redgular.stream().forEach(e -> System.out.println(e));
    }
}
