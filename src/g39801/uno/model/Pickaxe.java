package g39801.uno.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * this class build a pickaxe and mix it and display it
 *
 * @author kamal
 */
class Pickaxe {

    private final List<Card> thePickaxe = new ArrayList<>();

    /**
     * construction of the pickaxe
     *
     * @throws IllegalArgumentException if one or two argument are null
     */
    Pickaxe() {

        for (Color color : Color.values()) {
            for (Value value : Value.values()) {
                if (value == Value.ZERO) {
                    thePickaxe.add(new Card(color, value));
                } else {
                    thePickaxe.add(new Card(color, value));
                    thePickaxe.add(new Card(color, value));
                }
            }
        }
    }

    /**
     * draw a card from the pickaxe
     *
     * @return a card draw from the pickaxe
     */
    Card hit() {
        if (thePickaxe.isEmpty()) {
            throw new IllegalArgumentException("the deck is empty");
        }
        return thePickaxe.remove(0);
    }

    /**
     * mix the pickaxe
     */
    void shuffle() {

        Collections.shuffle(thePickaxe);
    }

    /**
     * return if the pickaxe is empty or not
     *
     * @return f the pickaxe is empty or not
     */
    boolean isEmpty() {
        return thePickaxe.isEmpty();
    }

    int size() {
        return thePickaxe.size();
    }

}
