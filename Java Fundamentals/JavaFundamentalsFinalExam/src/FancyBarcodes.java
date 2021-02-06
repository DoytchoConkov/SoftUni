import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Pattern pattern = Pattern.compile("([@]{1}[#]+)(?<barcode>[A-Z]{1}[A-Za-z0-9]{4,}[A-Z]{1})\\1");
        for (int i = 0; i < n; i++) {
            String barcodeText = scan.nextLine();
            Matcher matcher = pattern.matcher(barcodeText);
            if (!matcher.find()) {
                System.out.println("Invalid barcode");
            } else {
                String barcode = matcher.group("barcode");
                String group = "00";
                boolean flag = false;
                for (int j = 0; j < barcode.length(); j++) {
                    if (Character.isDigit(barcode.charAt(j))) {
                        if (group.equals("00") && !flag) {
                            group = String.valueOf((char) barcode.charAt(j));
                            flag = true;
                        } else {
                            group += (char) barcode.charAt(j);
                        }
                    }
                }
                System.out.printf("Product group: %s%n", group);
            }
        }
    }
}
