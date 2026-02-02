package mypack;

import java.util.*;

public class Player {

    //declaring variables
    Card[] hand;

    Player(Card[] initialCards) {
        this.hand = initialCards;
    }

    void printHand() {
        for (Card card : hand) {
            System.out.println(card.rank + " of " + card.suit);
        }
        System.out.println("Total value: " + getHandValue(this.hand));
    }

    int getHandValue(Card[] hand) {

        String[] suits = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};

        int suitValue;
        int totalValue = 0;
        for (String suit : suits) {
            suitValue = 0;

            for (Card card : hand) {
                if (card.suit == suit) {
                    suitValue += card.values.get(card.rank);
                }
            }

            if (suitValue > totalValue) {
                totalValue = suitValue;
           }
        }

        return totalValue;
    }
}
