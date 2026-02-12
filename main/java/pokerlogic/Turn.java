package pokerlogic;

import java.util.ArrayList;

public class Turn {
    String turn;

    public Turn(Deal deal) {
        turn = deal.dealCard();

    }
    public String getTurn() {
        return turn;
    }
}
