package hw_1.bai3;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};

    public static List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }

    public static void main(String[] args) {
        List<Card> deck = createDeck();
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}