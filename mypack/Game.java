package mypack;

import java.util.*;

public class Game {

    //declaring arrays
    String[] suits = {" of Spades", " of Diamonds", " of Clubs", " of Hearts"};
    String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    Card[] middle_cards = new Card[3];
 
    //declaring lists
    List<Card> deck = new ArrayList<>();
    List<Player> players = new ArrayList<>();

    //declaring other variables
    Scanner s = new Scanner(System.in);
    boolean valid = false;
    String user_in;
    int i_temp;
    Card c_temp;

    public void turn(Player p) {

        System.out.println("It is " + p.name + "'s turn. These are their cards:");
        p.print_cards();
        
        // validation loop 1
        System.out.println("Pick one of your cards to reject(1-3): ");
        valid = false;
        user_in = s.nextLine();
        while (!(valid)) {
            if ((user_in.trim().equals("1")) || (user_in.trim().equals("2")) ||  (user_in.trim().equals("3"))) {
                i_temp = Integer.parseInt(user_in.trim());
                c_temp = p.cards[i_temp-1]; 
                valid = true; }
            else {
                System.out.println("Invalid input. Try again: ");
                user_in = s.nextLine(); } }


        //validation loop 2
        System.out.println("Pick a card from the middle to take(1-3): ");
        valid = false;
        user_in = s.nextLine();
        while (!(valid)) {
            if ((user_in.trim().equals("1")) || (user_in.trim().equals("2")) ||  (user_in.trim().equals("3"))) {
                p.cards[i_temp-1] = middle_cards[Integer.parseInt(user_in.trim())-1];
                middle_cards[Integer.parseInt(user_in.trim())-1] = c_temp; 
                for (int i = 0; i < 10; i++) {System.out.println(""); }
                valid = true; }

            else {
                System.out.println("Invalid input. Try again: ");
                user_in = s.nextLine(); } } }
    

    public void build_deck() {
        deck.clear();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank)); } } 
        Collections.shuffle(deck); }

    public void deal_deck() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).cards = new Card[] {deck.get(i*3), deck.get((i*3) + 1),deck.get((i*3) + 2)}; }
            middle_cards = new Card[] {deck.get((players.size()+1)*3),deck.get((players.size()+1)*3+1),deck.get((players.size()+1)*3+2) };
            for (int i = 0; i < (players.size() * 3)+1; i++) {
                deck.remove(i); } }

    public void print_middle() {
        System.out.println("Cards in the middle:");
        for (Card card : middle_cards) {
            System.out.println(card.rank + card.suit); }
        System.out.println(""); }

    

    public void run() {
        build_deck();
        for (int i = 0; i < 4; i++) {
          players.add(new Player("Player " + Integer.toString(i+1))); } 
        deal_deck();

        //prints initial cards of all players
        /*for (Player p : players) {
            p.print_cards();} */

        for (int i = 0; i < 3; i++) {
            for (Player p: players) {
                print_middle();
                turn(p); } }

        System.out.println("End of game. Final cards:");
        for (Player p: players) {
                System.out.println(p.name + "'s cards:");
                p.print_cards(); } } }


