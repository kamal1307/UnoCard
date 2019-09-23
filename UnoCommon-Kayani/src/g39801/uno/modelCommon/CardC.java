package g39801.uno.modelCommon;

import java.io.Serializable;

/**
 *
 * this class build a card with a certain number of argument and display the
 * card
 *
 * @author kamal
 */
public class CardC implements Serializable {

    private static final long serialVersionUID = 65L;
    private Color color;
    private Value value;

    /**
     * construction of a card
     *
     * @param color the color of the card
     * @param value the value of the card
     */
    public CardC(Color color, Value value) {
        if (color == null || value == null) {
            throw new IllegalArgumentException("paramater is not adequate");
        }
        this.color = color;
        this.value = value;
    }

    /**
     * return the color of the card
     *
     * @return color of the card
     */
    public Color getColor() {
        return color;
    }

    /**
     * return the value of the card
     *
     * @return the value of the card
     */
    public Value getValue() {
        return value;
    }

    /**
     * compare if the card on the table is equals to a card of the hand
     *
     * @param card
     * @return true if the card is equals with a card of hand or not
     */
    public boolean compatible(CardC card) { // PAS EQUALS mais compatible
        if (this == card) {
            return true;
        }
        if (card == null) {
            return false;
        }
        return this.color == card.color || this.value == card.value;
    }

}
