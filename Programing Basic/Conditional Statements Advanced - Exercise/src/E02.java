import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String projection = scan.nextLine();
        int rows = Integer.parseInt(scan.nextLine());
        int colums = Integer.parseInt(scan.nextLine());
        switch (projection) {
            case "Premiere":
                System.out.printf("%.2f", 12.0 * rows * colums);
            break;
            case "Normal":
                System.out.printf("%.2f", 7.50 * rows * colums);
                break;
            case "Discount":
                System.out.printf("%.2f", 5.0 * rows * colums);
                break;
        }
    }
}
