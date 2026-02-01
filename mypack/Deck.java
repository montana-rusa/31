package mypack;

import java.util.*;

public class Deck {
    
    //declaring variables
    ArrayList<Card> cards;
    String[] suits = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
    String[] ranks = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};

    //constructor method
    Deck() {
        cards = new ArrayList<Card>();
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(cards);
    }



    



}
