import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());
        int x3 = Integer.parseInt(scan.nextLine());
        int y3 = Integer.parseInt(scan.nextLine());
        int x4 = Integer.parseInt(scan.nextLine());
        int y4 = Integer.parseInt(scan.nextLine());

        printLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    private static void printLongerLine(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int xLine1 = x1 - x2;
        int yLine1 = y1 - y2;
        int xLine2 = x3 - x4;
        int yLine2 = y3 - y4;
        int lenghtLine1 = xLine1 * xLine1 + yLine1 * yLine1;
        int lenghtLine2 = xLine2 * xLine2 + yLine2 * yLine2;
        if (lenghtLine2 > lenghtLine1) {
            printCoordinates(x3, y3, x4, y4);
        } else {
            printCoordinates(x1, y1, x2, y2);
        }
    }

    private static void printCoordinates(int x1, int y1, int x2, int y2) {
        int firstPoint = x1 * x1 + y1 * y1;
        int secondPoint = x2 * x2 + y2 * y2;
        if (secondPoint < firstPoint) {
            System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        } else {
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        }
    }
}
