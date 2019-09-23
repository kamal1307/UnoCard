package g39801.uno.model;

/**
 * all values of the card
 *
 * @author kamal
 */
public enum Value {
    /**
     * value Zero
     */
    ZERO(0), 
    
    /**
     * value One
     */
    ONE(1), 
    
    /**
     * value Two
     */
    TWO(2), 

    /**
     * value Three
     */
    THREE(3), 

    /**
     * value Four
     */
    FOUR(4), 

    /**
     * value Five
     */
    FIVE(5), 

    /**
     * value Six
     */
    SIX(6), 

    /**
     * value Seven
     */
    SEVEN(7),

    /**
     * value Eight
     */
    EIGHT(8), 

    /**
     * value Nine
     */
    NINE(9);

    private final int value;

    /**
     *
     * @param value the value of enumeration
     */
    Value(int value) {
        this.value = value;
    }

    /**
     * return the value of enumeration
     *
     * @return the value of enumeration
     */
    public int getValue() {
        return value;
    }

}
