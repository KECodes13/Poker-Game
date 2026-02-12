package pokerlogic;

import java.util.ArrayList;

public class Deck {
    // rank of cards
    String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q"};
    String[] suit = {"♠", "♥", "♦", "♣"};

    ArrayList<String> fullDeck = new ArrayList<>();

    public ArrayList<String> getDeck() {
        return fullDeck;
    }
    // constructor to create the full deck, happens when deck is called
    public Deck() {
        for (String s : suit) {
            for (String r : rank) {
                fullDeck.add(r + s);
            }
        }
        //System.out.println("deck created");
    }
}
