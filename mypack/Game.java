package mypack;

import java.util.*;

public class Game {

    Scanner scanner = new Scanner(System.in);
    boolean stick = false;



    // Deal initial cards to player and computers
    private static Card[] dealCards(Deck deck, int count) {
        Card[] cards = new Card[count];
        for (int i = 0; i < count; i++) {
            cards[i] = deck.cards.remove(0);
        }
        return cards; }
    
    void comSwap(Com com, Card[] middle, Deck deck) {

        Integer[] move = com.bestMove(com.hand, middle);

        if (move.length == 2) {
            // Swap cards
            Card temp = com.hand[move[0]];
            com.hand[move[0]] = middle[move[1]];
            middle[move[1]] = temp; }
        }
    
    boolean swap(Player player, Com com1, Com com2, Com com3, Card[] middle, Deck deck) {
        Integer swap1, swap2;
        String input;
        boolean comStick;

        
        System.out.println("\nMiddle Cards:");
        for (Card card : middle) {
            System.out.println(card.rank + " of " + card.suit);
        }


        input = "";
        while (!input.matches("[0-3]")) {
            System.out.print("enter the number of your card you want to swap (1, 2, or 3) or type '0' to 'stick': ");
            input = scanner.nextLine();
            if (!input.matches("[0-3]")) {
                System.out.println("Invalid input. Please enter 1, 2, 3, or 0."); } }
        if (input.equals("0")) {
            System.out.println("You chose to stick with your current hand.");
            stick = true;

            for (Com com : Arrays.asList(com1, com2, com3)) {
                comStick = com.get_stick();
                System.out.println(comStick);

                if (comStick) {
                    stick = true;
                }
                else {

                    if (!stick) {
                        comSwap(com, middle, deck);
                    }
                    
                    comStick = com.get_stick();
                    if (comStick) {
                        System.out.println("Computer " + (Arrays.asList(com1, com2, com3).indexOf(com) + 1) + " has chosen to stick.");
                    }   
            } }
            System.out.println( "\nThe computers have made their moves.");


            return stick;
         } else {
            swap1 = Integer.parseInt(input) - 1; 

            input = "";
            while (!input.matches("[1-3]")) {
            System.out.print("enter the number of the middle card you want to swap (1, 2, or 3): ");
            input = scanner.nextLine();
            if (!input.matches("[1-3]")) {
                System.out.println("Invalid input. Please enter 1, 2, or 3."); } }
            swap2 = Integer.parseInt(input) - 1; 

            // Swap cards
            Card temp = player.hand[swap1];
            player.hand[swap1] = middle[swap2]; 
            middle[swap2] = temp;

            System.out.println("\nYour new hand:");
            player.printHand(); }

        

        for (Com com : Arrays.asList(com1, com2, com3)) {
            comStick = com.get_stick();
                System.out.println(comStick);

                if (comStick) {
                    stick = true;
                }
                else {

                    if (!stick) {
                        comSwap(com, middle, deck);
                    }
                    
                    comStick = com.get_stick();
                    if (comStick) {
                        System.out.println("Computer " + (Arrays.asList(com1, com2, com3).indexOf(com) + 1) + " has chosen to stick.");
                    }   
            } }

        System.out.println( "\nThe computers have made their moves.");

        return stick;
    }

    void winner(Player player, Com com1, Com com2, Com com3) {
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("Player", player.getHandValue(player.hand));
        scores.put("Computer 1", com1.getHandValue(com1.hand));
        scores.put("Computer 2", com2.getHandValue(com2.hand));
        scores.put("Computer 3", com3.getHandValue(com3.hand));

        String winner = Collections.max(scores.entrySet(), Map.Entry.comparingByValue()).getKey();
        Integer winningScore = scores.get(winner);

        System.out.println("\nThe winner is " + winner + " with a score of " + winningScore + "!");
    }

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

        while (!(stick)) {

            stick = swap(player, com1, com2, com3, middle, deck);
        }

        // Final hands
        System.out.println("\nFinal Hands:");
        System.out.println("Player's Hand:");
        player.printHand();
        System.out.println("\nComputer 1's Hand:");
        com1.printHand();
        System.out.println("\nComputer 2's Hand:");
        com2.printHand();
        System.out.println("\nComputer 3's Hand:");
        com3.printHand();

        winner(player, com1, com2, com3);

        scanner.close();






    }

    
}
