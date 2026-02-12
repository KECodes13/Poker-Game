package pokerlogic;

public class Card {
    private String rank;
    private String suit;


    public Card(String code) { // check the rank of the hand, and the suit
        this.rank = code.substring(0, code.length() - 1); // ex 10
        this.suit = code.substring(code.length() - 1); // ex Diamonds

    }
    public String getRank() {
        return rank;
    }
    public String getSuit(){
        return suit;
    }
}