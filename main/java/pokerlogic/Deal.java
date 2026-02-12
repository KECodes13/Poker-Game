package pokerlogic;

import java.util.ArrayList;
import java.util.Random;

public class Deal {
    Deck deck;
    Random random = new Random();

    public Deal(Deck deck) {
        this.deck = deck;
    }

    public String dealCard() {
        // refer to fullDeck as stated above
        ArrayList<String> cards = deck.getDeck();
        if (cards.isEmpty()) {
            return "No cards left!";
        }
        int index = random.nextInt(cards.size());
        return cards.remove(index); // remove random card from deck
    }
}
