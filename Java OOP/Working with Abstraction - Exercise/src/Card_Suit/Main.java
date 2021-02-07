package Card_Suit;

public class Main {
    public static void main(String[] args) {
        CardSuits[] cards = CardSuits.values();
        System.out.println("Card Suits:");
        for (CardSuits card : cards) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.getValue(), card.name());
        }
    }
}
