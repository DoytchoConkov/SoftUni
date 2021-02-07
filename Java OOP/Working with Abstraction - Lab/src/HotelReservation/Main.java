package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        System.out.printf("%.2f",PriceCalculator.CalculatePrice(Double.parseDouble(input[0]),
                Integer.parseInt(input[1]), Season.valueOf(input[2]), Discount.valueOf(input[3])));
    }
}
