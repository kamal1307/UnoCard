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
public class PlayerTest {

    /**
     * test if it's possible to chose a index of the hand that does not exist
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDropCard() {
        Pickaxe pick = new Pickaxe();
        Player player = new Player(0, "kamal");
        player.getCard(8);

    }

    /**
     * test to chose a index of the hand
     */
    public void testDropCard1() {
        Pickaxe pick = new Pickaxe();
        Player player = new Player(0, "kamal");
        player.getCard(5);

    }

    /**
     * test if the score of a player is bigger than or equal to 100
     */
    @Test
    public void testWinGame() {
        Player player = new Player(0, "kamal");
        player.addScore(120);
        assertTrue(player.winGame());
    }

    /**
     * test if the score of a player is bigger than or equal to 100
     */
    @Test
    public void testWinGame1() {
        Player player = new Player(0, "kamal");
        player.addScore(90);
        assertFalse(player.winGame());
    }

    /**
     * test if a player win a manche or not
     */
    @Test
    public void testWinManch() {
        Player player = new Player(0, "kamal");
        Card c = new Card(Color.BLUE, Value.ONE);
        player.addCardHand(c);
        assertFalse(player.winRound());
    }

    /**
     * test if a player win a manche or not
     */
    @Test
    public void testWinManch1() {
        Player player = new Player(0, "kamal");
        player.clearHand();
        assertTrue(player.winRound());
    }

}
