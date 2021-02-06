import java.util.Scanner;

public class GiftboxCoverage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double giftBoxSide = Double.parseDouble(scan.nextLine());
        double areaGiftBox = giftBoxSide * giftBoxSide * 6;
        int sheets = Integer.parseInt(scan.nextLine());
        double sheetArea = Double.parseDouble(scan.nextLine());
        double totalSheetArea = 0;
        for (int i = 1; i <= sheets; i++) {
            if (i % 3 == 0) {
                totalSheetArea = totalSheetArea + 0.25 * sheetArea;
            } else {
                totalSheetArea = totalSheetArea + sheetArea;
            }
        }
        System.out.printf("You can cover %.2f%% of the box.", totalSheetArea / areaGiftBox * 100);
    }
}
