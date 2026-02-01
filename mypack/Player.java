package mypack;

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
        int totalValue = 0;
        for (Card card : hand) {
            totalValue += card.values.get(card.rank);
        }
        return totalValue;
    }
}
