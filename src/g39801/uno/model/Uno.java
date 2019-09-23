package g39801.uno.model;

import g39801.uno.bot.Bot;
import java.util.Observable;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is the heart of the play
 *
 * @author gkamal
 */
public class Uno extends Observable {

    private Pickaxe deck;

    int curPlayer;
    // private Card defausse;

    private final List<Card> defausse;

    private final List<Player> players;

    /**
     * contain all initialization of different arguments
     *
     * @param player
     */
    public Uno(List<Player> player) {
        players = player;
        deck = new Pickaxe();
        deck.shuffle();
        initializeNewHand();
        curPlayer = 0;
        defausse = new ArrayList();
        defausse.add(deck.hit());
 

    }

    /**
     * select a card from the hand of player
     *
     * @param cardId
     */
    public void playCard(int cardId) {
        Card card = players.get(curPlayer).getCard(cardId);
        if (getFlippedCard().compatible(card)) {
            defausse.add(card);
            players.get(curPlayer).removeCardHand(card);
            if (!players.get(curPlayer).winRound()) {
                nextPlayer();
            } else {
                newParty();

            }
            
            if(this.getCurrentPlayer().getClass()==Bot.class){
                playingIA();
            }

        }else{
            drawCard();
        }
        
        
        
        this.setChanged();
        notifyObservers();
    }

        private void playingIA(){
            int i;
            if ((i=getCurrentPlayer().getCardPos(getFlippedCard()))>=0) {
                playCard(i);
            }else{
                this.drawCard();
            }
        }
    /**
     * give the defause card
     *
     * @return
     */
    public Card getFlippedCard() {
        if(this.defausse.isEmpty()){
            throw new IllegalArgumentException("defauuse vide");
        }
        return this.defausse.get(defausse.size() - 1);
    }

    /**
     * return the current player
     *
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return players.get(curPlayer);

    }

    /**
     * return the id of current player
     *
     * @return the id of current player
     */
    public int getCurPlayer() {
        return curPlayer;
    }

    /**
     * draw a card from the pickaxe
     *
     */
    public void drawCard() {

        Card card = deck.hit();
        players.get(curPlayer).addCardHand(card);
        
        nextPlayer();
        setChanged();
        notifyObservers();
        
        if(getCurrentPlayer().getClass()==Bot.class){
            playingIA();
        }
        
        
    }

    /**
     * update the score of player if he win a party
     *
     * @param player the player
     * @return true if the player win a game or not
     */
    public boolean partyWin(Player player) {
        return players.get(curPlayer).winRound();
    }

    /**
     * initialize a newParty and update the score of player who winned a party
     */
    public void newParty() {
        deck = new Pickaxe();
        deck.shuffle();
        players.get(curPlayer).addScore(scorePlayer());
        initializeNewHand();
        setChanged();
        notifyObservers();

    }

    /**
     * to pass to next player
     */
    public void nextPlayer() {
        if (curPlayer >= players.size() - 1) {
            curPlayer = 0;
        } else {
            curPlayer++;
        }
        setChanged();
        notifyObservers();

    }

    /**
     * clear hand of all players
     */
    private void clearHandsPlayers() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).clearHand();
        }
    }

    /**
     * inialize the hand of all players
     *
     * @param deck the pi
     */
    private void initializeNewHand() {
        clearHandsPlayers();
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < 7; j++) {
                players.get(i).addCardHand(deck.hit());
            }
        }
        setChanged();
        notifyObservers();
    }

    /**
     * return the sum of the value of the cards of the players
     *
     * @return the sum of the value of the cards of the players
     */
    private int scorePlayer() {
        Card c;
        int somme = 0;
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.get(i).handSize(); j++) {

                somme += players.get(i).getCard(j).getValue().getValue();
            }
        }
        return somme;
    }

    /**
     * return the list of player
     *
     * @return the list of player
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * return the number of player
     *
     * @return the number of player
     */
    public int getNbPlayers() {
        return players.size();
    }

    /**
     * return the player at this index
     *
     * @param i the index of player
     * @return the player at this index
     */
    public Player getPlayer(int i) {
        return players.get(i);
    }

    /**
     * verifie if the card selected is compatible with the defause card
     *
     * @param card the card selected
     * @param other the defause card
     * @return true if they are compatible or not
     */
    public boolean compatible(Card card, Card other) {
        return ((card.getColor() == other.getColor())
                || (card.getValue() == other.getValue()));
    }
}
