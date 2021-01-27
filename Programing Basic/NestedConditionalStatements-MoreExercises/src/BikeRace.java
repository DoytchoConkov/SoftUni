import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int youngerBikers = Integer.parseInt(scan.nextLine());
        int SeniorBikers = Integer.parseInt(scan.nextLine());
        String typeRace = scan.nextLine();
        double youngerBikerPrice = 0;
        double seniorBikerPrice = 0;
        double sum;
        switch (typeRace) {
            case "trail":
                youngerBikerPrice = 5.5;
                seniorBikerPrice = 7;
                break;
            case "cross-country":
                youngerBikerPrice = 8;
                seniorBikerPrice = 9.5;
                if (youngerBikers + SeniorBikers >= 50) {
                    youngerBikerPrice = youngerBikerPrice * 0.75;
                    seniorBikerPrice = seniorBikerPrice * 0.75;
                }
                break;
            case "downhill":
                youngerBikerPrice = 12.25;
                seniorBikerPrice = 13.75;
                break;
            case "road":
                youngerBikerPrice = 20;
                seniorBikerPrice = 21.5;
                break;
        }
        sum = (youngerBikerPrice * youngerBikers + seniorBikerPrice * SeniorBikers) * 0.95;
        System.out.printf("%.2f", sum);
    }
}
