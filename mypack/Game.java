package mypack;

public class Game {

    // Deal initial cards to player and computers
    private static Card[] dealCards(Deck deck, int count) {
        Card[] cards = new Card[count];
        for (int i = 0; i < count; i++) {
            cards[i] = deck.cards.remove(0);
        }
        return cards; }

    void startGame() {
        Deck deck = new Deck();

        Player player = new Player(dealCards(deck, 3));
        Com com1 = new Com(dealCards(deck, 3));
        Com com2 = new Com(dealCards(deck, 3));
        Com com3 = new Com(dealCards(deck, 3));
        Card[] middle = dealCards(deck, 3);

        // Display hands
        System.out.println("Player's Hand:");
        player.printHand();

        System.out.println("z\nComputer 1's Hand:");
        com1.printHand();

        System.out.println("\nComputer 2's Hand:");
        com2.printHand();

        System.out.println("\nComputer 3's Hand:");
        com3.printHand();

        System.out.println("\nMiddle Cards:");
        for (Card card : middle) {
            System.out.println(card.rank + " of " + card.suit);
        }   




    }


    
}
