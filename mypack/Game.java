package mypack;

import java.util.*;
import java.lang.Math;

public class Game {

    String[] suits = {" of Spades", " of Diamonds", " of Clubs", " of Hearts"};
    String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    List<Card> deck = new ArrayList<>();
    Card[] middle_cards = new Card[3];
    List<Player> players = new ArrayList<>();

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

    public void run() {
        build_deck();
        for (int i = 0; i < 4; i++) {
          players.add(new Player()); } 
        deal_deck();
        for (Player player : players) {
            player.print_cards();}


    

    }

    

    }


