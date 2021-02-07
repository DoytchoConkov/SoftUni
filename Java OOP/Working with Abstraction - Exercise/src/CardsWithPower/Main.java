package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cardRank = scan.nextLine();
        String cardSuit = scan.nextLine();
        System.out.printf("Card name: %s of %s; Card power: %d%n", cardRank, cardSuit, CardRank.valueOf(cardRank).getValue() + CardSuits.valueOf(cardSuit).getValue());
    }
}
