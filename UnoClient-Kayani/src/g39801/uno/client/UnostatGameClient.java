package g39801.uno.client;

import g39801.uno.message.player.PlayerC;
import g39801.uno.modelCommon.CardC;
import java.util.List;

/**
 * contains status of game
 *
 * @author kamal
 */
class UnostatGameClient {

    private CardC flipeCard;
    private boolean isEnd;
    private List<PlayerC> playersC;
    private List<CardC> hands;
    
    /**
     *
     * @param flipeCard the defausse card
     * @param hands hand of a player
     * @param playersC liste of players
     * @param isEnd if the game is win or not
     */
    /**
     * return the defausse card
     *
     * @return return the defausse card
     */
    CardC getFlipeCard() {
        return flipeCard;
    }

    /**
     * return the hand of player
     *
     * @return the hand of player
     */
    List<CardC> getHands() {
        return hands;
    }

    /**
     * return if the status of game is end or not
     *
     * @return if the status of game is end or not
     */
    boolean isEnd() {
        return isEnd;
    }

    /**
     * return list of players
     *
     * @return list of players
     */
    List<PlayerC> getPlayersC() {
        return playersC;
    }

    /**
     * modified the flipeCard
     * @param flipeCard the update flipeCard 
     */
    void setFlipeCard(CardC flipeCard) {
        this.flipeCard = flipeCard;
    }

    /**
     * modified the end game
     * @param isEnd the new boolean value
     */
    void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    /**
     * modified the playersC list
     * @param playersC the new playersC list
     */
    void setPlayersC(List<PlayerC> playersC) {
        this.playersC = playersC;
    }

    /**
     * modified the hands of player
     * @param hands the new hand
     */
    void setHands(List<CardC> hands) {
        this.hands = hands;
    }
}
