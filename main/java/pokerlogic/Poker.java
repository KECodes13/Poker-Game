package pokerlogic;

import java.util.ArrayList;

/*
* This is Kyle Ernste's first personal project. The project is a Texas Hold'em poker hand analyzer. The program will
* give you a random hand out of the deck of cards, and proceed to print out the flop, turn, and river.
* next, the program will analyze your hand and give back to you what it is and the strength of that hand.
*
*/
public class Poker {
    public static String playGame() {
        StringBuilder output = new StringBuilder();
        // I want to add in a scanner that asks the user if they are ready after this
        output.append("Welcome to Texas Hold'em Poker Hand Analyzer!\n");



        Deck deck = new Deck();
        Deal deal = new Deal(deck);


        String card = deal.dealCard();
        String card2 = deal.dealCard();

        output.append("Your Cards: ").append(card).append(", ").append(card2).append("\n");


        Flop flop = new Flop(deal);


        output.append("Flop is: ").append(flop.getFlop()).append("\n");


        Turn turn = new Turn(deal);

        output.append("Turn is: ").append(turn.getTurn()).append("\n");


        River river = new River(deal);

        output.append("River is: ").append(river.getRiver()).append("\n");

        ArrayList<String> allCards = new ArrayList<>(); // adding all cards into a new arraylist to analyze
        allCards.add(card);
        allCards.add(card2);
        allCards.addAll(flop.getFlop());
        allCards.add(turn.getTurn());
        allCards.add(river.getRiver());


        output.append("Full Board: ").append(flop.getFlop()).append(" ")
                .append(turn.getTurn()).append(" ")
                .append(river.getRiver()).append("\n");

        output.append("Your Cards: ").append(card).append(", ").append(card2).append("\n");



        ArrayList<Card> finalHand = new ArrayList<>();
        for(String c : allCards) {
            finalHand.add(new Card(c));
        }

        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] rankCount = new int[ranks.length];

        for(Card c : finalHand) { // checking the ranks
            for (int i = 0; i < ranks.length; i++) {
                if (c.getRank().equals(ranks[i])) {
                    rankCount[i]++;
                }
            }
        }

        String[] suits = {"♠", "♥", "♦", "♣"}; // checking if flush
        int[] suitCount = new int[suits.length];
        for (Card c : finalHand) {
            for (int i = 0; i < suits.length; i++) {
                if (c.getSuit().equals(suits[i])) {
                    suitCount[i]++;
                }
            }
        }
        boolean[] straightCheck = new boolean[ranks.length]; // straight checking
        for (int i = 0; i < ranks.length; i++ ) {
            if (rankCount[i] > 0) straightCheck[i] = true;
        }
        int inRow = 0;
        boolean straight = false;
        for (int i = 0; i < straightCheck.length; i++) {
            if (straightCheck[12] && straightCheck[0] && straightCheck[1] && straightCheck[2] && straightCheck[3]) straight = true;
            if(straightCheck[i]) {
                inRow++;
                if (inRow >= 5) straight = true;
            } else {
                inRow = 0;
            }
        }

        int pairs = 0;
        boolean threeOfKind = false;
        boolean Quads = false;
        boolean fullHouse = false;
        boolean flush = false;

        for (int c : suitCount) {
            if (c >= 5) {
                flush = true;
            }
        }
        for (int count : rankCount) {
            if (count == 2) pairs++;
            if (count == 3) threeOfKind = true;
            if (count == 4) Quads = true;

        }



        if (straight && flush) output.append("Straight Flush: Hand Strength 9/10\n");
        else if (Quads) output.append("Four of a Kind: Hand Strength 8/10\n");
        else if (threeOfKind && pairs >= 1) output.append("Full House: Hand Strength 7/10\n");
        else if (flush) output.append("Flush: Hand Strength 6/10\n");
        else if (straight) output.append("Straight: Hand Strength 5/10\n");
        else if (threeOfKind) output.append("Three of a Kind: Hand Strength 4/10\n");
        else if (pairs == 2) output.append("Two Pair: Hand Strength 3/10\n");
        else if (pairs == 1) output.append("Pair: Hand Strength 2/10\n");
        else output.append("High Card: Hand Strength 1/10\n");

    return output.toString();
    }
}
