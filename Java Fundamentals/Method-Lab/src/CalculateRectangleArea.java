import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        System.out.println(rectangleArea(width, length));
    }

    public static int rectangleArea(int w, int l) {
        int area = w * l;
        return area;
    }
}
