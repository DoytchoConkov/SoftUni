import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String key[] = scan.nextLine().split("\\s+");
        String input = scan.nextLine();
        while (!"find".equals(input)) {
            String decryptedText = "";
            int br = 0;
            for (int i = 0; i < input.length(); i++) {
                decryptedText += (char) (input.charAt(i) - Integer.parseInt(key[br]));
                br++;
                if (br == key.length) {
                    br = 0;
                }
            }
            String[] tokens = decryptedText.split("&");
            String type = tokens[1];
            int startIndex = tokens[2].indexOf('<');
            int endIndex = tokens[2].indexOf('>');
            String coordinates = tokens[2].substring(startIndex + 1, endIndex);
            System.out.printf("Found %s at %s%n", type, coordinates);
            input = scan.nextLine();
        }
    }
}
