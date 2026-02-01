package mypack;

import java.util.*;

public class Game {

    // Deal initial cards to player and computers
    private static Card[] dealCards(Deck deck, int count) {
        Card[] cards = new Card[count];
        for (int i = 0; i < count; i++) {
            cards[i] = deck.cards.remove(0);
        }
        return cards; }

    boolean swap(Player player, Com com1, Com com2, Com com3, Card[] middle, Deck deck) {

        Scanner scanner = new Scanner(System.in);
        Integer swap1, swap2;
        String input;

        input = "";
        while (input != "1" && input != "2" && input != "3" && input != "0") {
        System.out.print("enter the number of your card you want to swap (1, 2, or 3) or type '0' to 'stick': ");
        input = scanner.nextLine();
        if (input != "1" && input != "2" && input != "3" && input != "0") {
            System.out.println("Invalid input. Please enter 1, 2, 3, or 0."); } }
        if (input == "0") {
            System.out.println("You chose to stick with your current hand.");
            scanner.close();
            return true;
         } else {
            swap1 = Integer.parseInt(input) - 1; 

            input = "";
            while (input != "1" && input != "2" && input != "3") {
            System.out.print("enter the number of the middle card you want to swap (1, 2, or 3): ");
            input = scanner.nextLine();
            if (input != "1" && input != "2" && input != "3") {
                System.out.println("Invalid input. Please enter 1, 2, or 3."); } }
            swap2 = Integer.parseInt(input) - 1; 

            // Swap cards
            Card temp = player.hand[swap1];
            player.hand[swap1] = middle[swap2]; 
            middle[swap2] = temp;

            System.out.println("\nYour new hand:");
            player.printHand(); }
        scanner.close();
        return false;

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

        System.out.println("\nComputer 1's Hand:");
        com1.printHand();

        System.out.println("\nComputer 2's Hand:");
        com2.printHand();

        System.out.println("\nComputer 3's Hand:");
        com3.printHand();

        System.out.println("\nMiddle Cards:");
        for (Card card : middle) {
            System.out.println(card.rank + " of " + card.suit);
        }

        swap(player, com1, com2, com3, middle, deck);




    }


    
}
