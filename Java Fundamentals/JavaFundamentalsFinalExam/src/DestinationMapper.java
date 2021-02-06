import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        List<String> destinations = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            destinations.add(matcher.group("destination"));
        }
        int travelPoints = 0;
        for (String destination : destinations) {
            travelPoints += destination.length();
        }
        System.out.printf("Destinations: %s%n", String.join(", ", destinations));
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
