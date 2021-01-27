import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String season = scan.nextLine();
        String groupType = scan.nextLine();
        int studentsCnt = Integer.parseInt(scan.nextLine());
        int nightsCnt = Integer.parseInt(scan.nextLine());
        String sportType = "";
        double pricePerNight = 0;
        double totalPrice = 0;
        switch (season) {
            case "Winter":
                switch (groupType) {
                    case "boys":
                        sportType = "Judo";
                        pricePerNight = 9.6;
                        break;
                    case "girls":
                        sportType = "Gymnastics";
                        pricePerNight = 9.6;
                        break;
                    case "mixed":
                        sportType = "Ski";
                        pricePerNight = 10;
                        break;
                }
                break;
            case "Spring":
                switch (groupType) {
                    case "boys":
                        sportType = "Tennis";
                        pricePerNight = 7.2;
                        break;
                    case "girls":
                        sportType = "Athletics";
                        pricePerNight = 7.2;
                        break;
                    case "mixed":
                        sportType = "Cycling";
                        pricePerNight = 9.5;
                        break;
                }
                break;
            case "Summer":
                switch (groupType) {
                    case "boys":
                        sportType = "Football";
                        pricePerNight = 15;
                        break;
                    case "girls":
                        sportType = "Volleyball";
                        pricePerNight = 15;
                        break;
                    case "mixed":
                        sportType = "Swimming";
                        pricePerNight = 20;
                        break;
                }
                break;
        }
        totalPrice = pricePerNight * studentsCnt;
        if (studentsCnt >= 10 && studentsCnt < 20) {
            totalPrice = totalPrice * 0.95;
        } else if (studentsCnt >= 20 &&studentsCnt < 50) {
            totalPrice = totalPrice * 0.85;
        } else if (studentsCnt >= 50) {
            totalPrice = totalPrice * 0.5;
        }
        System.out.printf("%s %.2f lv.", sportType, totalPrice*nightsCnt);
    }
}
