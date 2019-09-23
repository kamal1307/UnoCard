package g39801.uno.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * this class contains the relative informations about a player
 *
 * @author kamal
 */
public  class Player {

    private final int id;
    private final String name;
    private int score;
    private final List<Card> hands = new ArrayList<>();

    /**
     * construction of a player
     *
     * @param id the number of player
     * @param name the name of the player
     */
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        score = 0;
    }

    /**
     * return the id of he player
     *
     * @return the id of he player
     */
    public int getId() {
        return id;
    }

    /**
     * return the name of the player
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * return the score of the player
     *
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * the score of the player is updated
     *
     * @param score the score of the player
     */
    public void addScore(int score) {
        this.score += score;
    }

    /**
     * clear the hand of player
     */
    void clearHand() {
        hands.clear();
    }

    /**
     * add a card in this hand
     *
     * @param card the card added
     */
    void addCardHand(Card card) {
        hands.add(card);
    }

    /**
     * remove a card in this hand
     *
     * @param card the card removed
     */
    void removeCardHand(Card card) {
        hands.remove(card);
    }

    /**
     * the card compared with the card on the table
     *
     * @param idCard the number of the card compared
     * @return the card compared
     */
    public Card getCard(int idCard) {
        if (idCard > hands.size()) {
            throw new IllegalArgumentException("Card doesn't exist");
        }
       
        return hands.get(idCard);
    }
    public int getCardPos(Card card){
        return -1;
    }
    /**
     * return true if the score is equal or bigger than 100
     *
     * @return true if the score is equal or bigger than 100
     */
    public boolean winGame() {
        return this.getScore() >= 15;
    }

    /**
     * return true if the hand of the current player is empty or not
     *
     * @return true if the hand of the current player is empty or not
     */
    public boolean winRound() {
        return hands.isEmpty();
    }

    /**
     * return the size of the hand of the player
     *
     * @return the size of the hand of the player
     */
    public int handSize() {
        return hands.size();
    }

    /**
     * return the hand of player
     *
     * @return the hand of player
     */
    public List<Card> getHands() {
        return hands;
    }

}
