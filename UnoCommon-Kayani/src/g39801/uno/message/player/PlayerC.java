/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.message.player;

import java.io.Serializable;

/**
 * contain information about a player
 * @author g39801
 */
public class PlayerC implements Serializable{
    private final static long serialVersionUID = 64L;
    private final String name;
    private final int score;
    private final int nbCards;

    /**
     * the constructor creat a player with the required information
     * @param name
     * @param score
     * @param nbCards 
     */
    public PlayerC(String name, int score, int nbCards) {
        this.name = name;
        this.score = score;
        this.nbCards = nbCards;
    }

   /**
    * return name of player
    * @return name of player
    */
    public String getName() {
        return name;
    }

    /**
     * return score of player
     * @return score of player
     */
    public int getScore() {
        return score;
    }

    /**
     * return the number of remaining card
     * @return the number of remaining card 
     */
    public int getNbCards() {
        return nbCards;
    }
   


    
}
