import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String day = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        int tiketPrice = 0;
        switch (day) {
            case "Weekday":
                if (age >= 0 && age <= 18) {
                    tiketPrice = 12;
                } else if (age >= 19 && age <= 64) {
                    tiketPrice = 18;
                } else if (age >= 65 && age <= 122) {
                    tiketPrice = 12;
                }
                break;
            case "Weekend":
                if (age >= 0 && age <= 18) {
                    tiketPrice = 15;
                } else if (age >= 19 && age <= 64) {
                    tiketPrice = 20;
                } else if (age >= 65 && age <= 122) {
                    tiketPrice = 15;
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    tiketPrice = 5;
                } else if (age >= 19 && age <= 64) {
                    tiketPrice = 12;
                } else if (age >= 65 && age <= 122) {
                    tiketPrice = 10;
                }
                break;
        }
        if (tiketPrice > 0) {
            String price = String.format("%d$", tiketPrice);
            System.out.println(price);
        } else {
            System.out.println("Error!");
        }
    }
}
