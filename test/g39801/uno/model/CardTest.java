/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kamal
 */
public class CardTest {

    /**
     * test a construction of card if one of two argument is null
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestConstructor() {
        Card aCard = new Card(Color.BLUE, null);

    }

    /**
     * test a construction of card if one of two argument is null
     */
    @Test(expected = IllegalArgumentException.class)
    public void CardTest1() {
        Card aCard = new Card(null, Value.EIGHT);
    }

    /**
     * test a construction of card if two argument are null
     */
    @Test(expected = IllegalArgumentException.class)
    public void CardTest2() {
        Card aCard = new Card(null, null);
    }

    /**
     * test a construction of card
     */
    @Test
    public void CardTeste() {
        Card aCard = new Card(Color.BLUE, Value.SIX);
    }

    /**
     * test if a card is equals with the card on the table or not
     */
    @Test
    public void testCompatible() {
        Card aCard = new Card(Color.BLUE, Value.SIX);
        Card bcard = new Card(Color.GREEN, Value.SIX);
        assertTrue(aCard.compatible(bcard));
    }

    /**
     * test if a card is equals with the card on the table or not
     */
    @Test
    public void testCompatible1() {
        Card aCard = new Card(Color.BLUE, Value.SIX);
        Card bCard = new Card(Color.BLUE, Value.FOUR);
        assertTrue(aCard.compatible(bCard));
    }

    /**
     * test if a card is equals with the card on the table or not
     */
    @Test
    public void testCompatible2() {
        Card aCard = new Card(Color.BLUE, Value.SEVEN);
        Card bcard = new Card(Color.GREEN, Value.SIX);
        assertFalse(aCard.compatible(bcard));
    }

}
