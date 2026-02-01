package mypack;

import java.util.*;

public class Com extends Player {

    //constructor method
    Com(Card[] initialCards) {
        super(initialCards);
    }

    Integer[] bestMove(Card[] hand, Card[] middle) {

        HashMap<Integer[], Integer> handValues = new HashMap<Integer[], Integer>();
        Integer[][] options = {
            {0}, {0, 1}, {0, 2}, {1, 0}, {1, 2},
            {2, 0}, {2, 1}};

            for (Integer[] option : options) {
                Card[] newHand = hand.clone();

                if (option.length == 2) {
                    newHand[option[0]] = middle[option[1]]; }
    
                int totalValue = getHandValue(newHand);
                handValues.put(option, totalValue); }

                Integer bestValue = Collections.max(handValues.values());
                for (Integer[] key : handValues.keySet()) {
                    if (handValues.get(key) == bestValue) {
                        return key;
                    }
                }
                return options[0]; // Default return if no best move found
            }



    }
    

