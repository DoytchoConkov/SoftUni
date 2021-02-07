package HotelReservation;

public class PriceCalculator {
    public static double CalculatePrice(double pricePerDay, int numberOfDays, Season season, Discount discount){
        return pricePerDay*numberOfDays* season.getValue()*(100-discount.getValue())/100;
    }
}
