package mypack;

public class Game {

    void startGame() {
        Deck deck = new Deck();

        // Deal initial cards to player and computer
        Card[] playerCards = {deck.cards.remove(0), deck.cards.remove(0), deck.cards.remove(0)};
        Card[] comCards = {deck.cards.remove(0), deck.cards.remove(0), deck.cards.remove(0)};

        Player player = new Player(playerCards);
        Com com = new Com(comCards);

        System.out.println("Player's Hand:");
        player.printHand();
    }


    
}
