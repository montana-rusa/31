package mypack;

public class Player {

    Card[] cards = new Card[3];
    String name;

    public Player(String name) {
        this.name = name;
    }

    public void print_cards() {
        System.out.println(cards[0].rank + cards[0].suit);
        System.out.println(cards[1].rank + cards[1].suit);
        System.out.println(cards[2].rank + cards[2].suit);
        System.out.println("");
    }
}
    
