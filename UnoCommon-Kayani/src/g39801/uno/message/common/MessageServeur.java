package g39801.uno.message.common;

import g39801.uno.message.player.PlayerC;
import g39801.uno.modelCommon.CardC;
import java.io.Serializable;
import java.util.List;

/**
 * communication of a message from server to the client
 *
 * @author kamal
 */
public class MessageServeur implements Serializable{
    
    private final static long serialVersionUID = 86L;
    private final  boolean isEnd;
    private final  CardC flippedCard;
    private final  List<CardC> handsPlayer;
    private final  List<PlayerC> players;

    /**
     * the constructeur creat a mesage sent to the client
     * @param isEnd signal if is gameOver
     * @param flippedCard the defausse card
     * @param handsPlayer list of card in the hand of player
     * @param players list players
     */
    public MessageServeur(boolean isEnd, CardC flippedCard,
            List<CardC> handsPlayer, List<PlayerC> players) {
        this.isEnd = isEnd;
        this.flippedCard = flippedCard;
        this.handsPlayer = handsPlayer;
        this.players = players;
    }

    /**
     * return if the game is end or not
     * @return if the game is end or not
     */
    public boolean isIsEnd() {
        return isEnd;
    }

    /**
     * return the flippedCard
     * @return the flippedCard
     */
    public CardC getFlippedCard() {
        return flippedCard;
    }

    /**
     * return the hand of player
     * @return 
     */
    public List<CardC> getHandsPlayer() {
        
        return handsPlayer;
    }

    /**
     * return a list of player
     * @return  a list of player
     */
    public List<PlayerC> getPlayers() {
        return players;
    }

}
