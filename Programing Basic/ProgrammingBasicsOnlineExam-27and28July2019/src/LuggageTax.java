import java.util.Scanner;

public class LuggageTax {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tax = 0;
        int w = Integer.parseInt(scan.nextLine());
        int d = Integer.parseInt(scan.nextLine());
        int h = Integer.parseInt(scan.nextLine());
        String priority = scan.nextLine();
        int volume = h * d * w;
        if (volume > 50 && volume <= 100) {
            if (priority.equals("true")) {
                tax = 0;
            } else {
                tax = 25;
            }
        } else if (volume > 100 &&volume <= 200){
            if (priority.equals("true")) {
                tax = 10;
            } else {
                tax = 50;
            }
        }else if (volume > 200 && volume <= 300) {
            if (priority.equals("true")) {
                tax = 20;
            } else {
                tax = 100;
            }
        }
        System.out.printf("Luggage tax: %.2f", tax);
    }
}
