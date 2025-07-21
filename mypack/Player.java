package mypack;

public class Player {

    Card[] cards = new Card[3];

    String name;
    int[] suit_scores = {0,0,0,0};

    public Player(String name) {
        this.name = name;
    }

    public void print_cards() {
        System.out.println("1. " + cards[0].rank + cards[0].suit);
        System.out.println("2. " + cards[1].rank + cards[1].suit);
        System.out.println("3. " + cards[2].rank + cards[2].suit);
        System.out.println(""); }

    public int find_max(int[] a) {
        int max = 0;
        for (int num : a) {
            if (num > max) {max = num; }
        } return max;}

    public int calculate_score(String[] suits) {

        if ((cards[1].rank.equals(cards[2].rank)) && (cards[2].rank.equals(cards[3].rank))) {return 30;}
        
        for (int i = 0; i < 4; i++) {
            for (Card card : cards) {
                if (card.suit == suits[i]) {
                    if ((card.rank.equals("King")) || (card.rank.equals("Queen")) || (card.rank.equals("Jack"))) {
                        suit_scores[i] += 10;
                    } else if (card.rank.equals("Ace")) {
                        suit_scores[i] += 11;
                    } else {suit_scores[i] += Integer.parseInt(card.rank); } } } }
        return find_max(suit_scores); }
}
    
