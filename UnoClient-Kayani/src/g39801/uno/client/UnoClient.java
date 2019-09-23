/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.client;

import g39801.uno.message.common.MessageClient;
import g39801.uno.message.common.MessageServeur;
import g39801.uno.message.common.Status;
import g39801.uno.message.player.PlayerC;
import g39801.uno.modelCommon.CardC;
import java.io.IOException;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author g39801
 */
public class UnoClient extends Observable {

    private final UnoNetworkClient network;
    private final UnostatGameClient gameStat;

    public UnoClient(String host, int port) throws IOException {
        network = new UnoNetworkClient(port, host);
        gameStat = new UnostatGameClient();
    }

    /**
     * writing of the stream sended to server
     *
     * @param msgClient the message sended to server
     * @throws IOException I/O Exception
     */
    public void writeServer(MessageClient msgClient) throws IOException {
        network.writingServer(msgClient);
        this.waitFromServer();
    }

    /**
     * reading, delegate method of UnoNetworkClient
     *
     * @return reading of server deleagate method of UnoNetworkClient
     * @throws IOException I/O Eception
     * @throws ClassNotFoundException The ClassNotFoundException
     */
    private MessageServeur readServer() throws IOException, ClassNotFoundException {
        return network.readingServer();
    }

    /**
     * receive a message fram server and wait to traiting it
     */
    private void waitFromServer() {
        try {
            MessageServeur msgserv;
            
                msgserv = network.readingServer();
                System.out.println(msgserv.getFlippedCard().getValue());
                gameStat.setHands(msgserv.getHandsPlayer());
                gameStat.setFlipeCard(msgserv.getFlippedCard());
                gameStat.setIsEnd(msgserv.isIsEnd());
                gameStat.setPlayersC(msgserv.getPlayers());
                this.setChanged();
                notifyObservers();
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * begin the game with instanciation of uno
     *
     * @param name the name of player
     * @throws IOException I/O exception
     */
    public void play(String name) throws IOException {
        MessageClient client = new MessageClient(name, -1, Status.CONNECT,false);
        network.writingServer(client);
        waitFromServer();

    }

    /**
     * send the information about the playable card
     *
     * @param index the index of card selected
     * @throws IOException I/O exception
     */
    public void playCard(int index,boolean check) throws IOException {
        MessageClient client = new MessageClient(null, index, Status.PLAY,check);
        network.writingServer(client);
        waitFromServer();
    }

    /**
     * send the information for draw a card
     *
     * @throws IOException I/O exception
     */
    public void playerDrawCard() throws IOException {
        MessageClient client = new MessageClient(null, -1, Status.DRAWCARD,false);
        network.writingServer(client);
        waitFromServer();
    }

    /**
     * return the defausse card
     *
     * @return return the defausse card
     */
    public CardC getFlipeCard() {
        return gameStat.getFlipeCard();
    }

    /**
     * return the hand of player
     *
     * @return the hand of player
     */
    public List<CardC> getHands() {
        return gameStat.getHands();
    }

    /**
     * return if the status of game is end or not
     *
     * @return if the status of game is end or not
     */
    public boolean isEnd() {
        return gameStat.isEnd();
    }

    /**
     * return list of players
     *
     * @return list of players
     */
    public List<PlayerC> getPlayersC() {
        return gameStat.getPlayersC();
    }

}
