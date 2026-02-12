package pokerlogic;

import java.util.ArrayList;

public class Flop {
    ArrayList<String> flopCards = new ArrayList<>();

    public Flop(Deal deal) {
        for (int i = 0; i < 3; i++) {
            flopCards.add(deal.dealCard());
        }
    }
    public ArrayList<String> getFlop() {
        return flopCards;
    }
}
