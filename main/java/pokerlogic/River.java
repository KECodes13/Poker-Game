package pokerlogic;

import java.util.ArrayList;

public class River {
    String river;

    public River(Deal deal) {
        river = deal.dealCard();
    }
    public String getRiver() {
        return river;
    }
}
