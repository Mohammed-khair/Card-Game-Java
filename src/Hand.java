import java.util.*;

/**
 * A poker hand is a list of cards, which can be of some "kind" (pair, straight, etc.)
 *
 * @author Mohammed Abu Alkhair
 *  @version 0.0
 */
public class Hand implements Comparable<Hand> {

    public enum Kind {HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, 
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH}

    private final List<Card> cards;

    /**
     * Create a hand from a string containing all cards (e,g, "5C TD AH QS 2D")
     */
    public Hand(String c) {
        String[] cardsStringList = c.split(""); // Split the string into an Array
        cards = new ArrayList<>();                    // Create a new hand

        for (int i = 0; i < 5; i++) {                 // Fill the hand with five cards.
            cards.add(new Card(cardsStringList[i]));
        }
    }

    
    /**
     * @returns true if the hand has n cards of the same rank
	 * e.g., "TD TC TH 7C 7D" returns True for n=2 and n=3, and False for n=1 and n=4
     */
    protected boolean hasNKind(int n) {
        HashMap<Card.Rank, Integer> nKind = new HashMap<Card.Rank, Integer>();

        for (Card c : cards){
            if(nKind.containsKey(c.getRank())) {
                int occurrence = nKind.get(c.getRank());
                nKind.replace(c.getRank(),occurrence++ );
            } else {
                nKind.put(c.getRank(), 1);
            }
        }
        return nKind.values().max() == n;

    }
    
    /**
	 * Optional: you may skip this one. If so, just make it return False
     * @returns true if the hand has two pairs
     */
    public boolean isTwoPair() {
        return false;
    }   
    
    /**
     * @returns true if the hand is a straight 
     */
    public boolean isStraight() {
        
    }
    
    /**
     * @returns true if the hand is a flush
     */
    public boolean isFlush() {
        
    }
    
    @Override
    public int compareTo(Hand h) {
        //hint: delegate!
		//and don't worry about breaking ties
    }
    
    /**
	 * This method is already implemented and could be useful! 
     * @returns the "kind" of the hand: flush, full house, etc.
     */
    public Kind kind() {
        if (isStraight() && isFlush()) return Kind.STRAIGHT_FLUSH;
        else if (hasNKind(4)) return Kind.FOUR_OF_A_KIND; 
        else if (hasNKind(3) && hasNKind(2)) return Kind.FULL_HOUSE;
        else if (isFlush()) return Kind.FLUSH;
        else if (isStraight()) return Kind.STRAIGHT;
        else if (hasNKind(3)) return Kind.THREE_OF_A_KIND;
        else if (isTwoPair()) return Kind.TWO_PAIR;
        else if (hasNKind(2)) return Kind.PAIR; 
        else return Kind.HIGH_CARD;
    }

}
