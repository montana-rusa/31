package mypack;

import java.util.*;

public class Card {

    //declaring variables
    String rank, suit;
    HashMap<String, Integer> values = new HashMap<String, Integer>();


    //constructor method
    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;

        values.put("ONE", 1);
        values.put("TWO", 2);
        values.put("THREE", 3);
        values.put("FOUR", 4);
        values.put("FIVE", 5);
        values.put("SIX", 6);
        values.put("SEVEN", 7);
        values.put("EIGHT", 8);
        values.put("NINE", 9);
        values.put("TEN", 10);
        values.put("JACK", 10);
        values.put("QUEEN", 10);
        values.put("KING", 10);
        values.put("ACE", 11);
    }





}

