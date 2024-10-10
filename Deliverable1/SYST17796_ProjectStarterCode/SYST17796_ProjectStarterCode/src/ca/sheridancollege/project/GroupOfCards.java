/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    private ArrayList<PlayingCard> cards = new ArrayList<>();

    public GroupOfCards() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) { // 11 = Jack, 12 = Queen, 13 = King, 14 = Ace
                cards.add(new PlayingCard(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public PlayingCard drawCard() {
        return cards.remove(0); // Draw the top card
    }

    public int size() {
        return cards.size();
    }

}//end class
