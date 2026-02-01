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
        System.out.println("Total value: " + getHandValue());
    }

    int getHandValue() {
        int totalValue = 0;
        for (Card card : hand) {
            totalValue += card.values.get(card.rank);
        }
        return totalValue;
    }
}
