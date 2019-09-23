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
public class PickaxeTest {

    /**
     * test if it's possible to take a card when the pickaxe is empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testHit() {
        Pickaxe pick = new Pickaxe();
        for (int i = 0; i < 67; i++) {
            pick.hit();
        }
        pick.hit();
    }

    /**
     * test to take a card of the pickaxe
     */
    @Test
    public void testHit1() {
        Pickaxe pick = new Pickaxe();
        pick.hit();
    }

    /**
     * test if the pickaxe is empty or not
     */
    @Test
    public void testIsEmpty() {
        Pickaxe pick = new Pickaxe();
        assertFalse(pick.isEmpty());
    }

    /**
     * test if the pickaxe is empty or not
     */
    @Test
    public void testIsEmpty1() {
        Pickaxe pick = new Pickaxe();
        for (int i = 0; i < 67; i++) {
            pick.hit();
        }
        assertTrue(pick.isEmpty());
    }

}
