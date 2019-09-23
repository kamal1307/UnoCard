package g39801.uno.serveur;

import g39801.uno.bot.Bot;
import g39801.uno.model.Uno;
import g39801.uno.message.common.MessageClient;
import g39801.uno.message.common.MessageServeur;
import g39801.uno.message.player.PlayerC;
import g39801.uno.model.Player;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * performs game management
 *
 * @author g39801
 */
public class ThreadClient extends Thread {

    private final Socket localSocket;
    private Uno uno;
    //private final UnoNetworkServeur serveurNetwork;
    private MessageClient msgClient;
    private MessageServeur msgServeur;
    private ObjectOutputStream send;
    private final ObjectInputStream recieved;
    private List<PlayerC> players;
    private List<Player> playersOrg;

    /**
     * the constructor creat a socket of client
     *
     * @param socket socket of client
     * @throws IOException I/O exception
     */
    public ThreadClient(Socket socket) throws IOException {
        localSocket = socket;
        players = new ArrayList<>();
        //serveurNetwork = new UnoNetworkServeur(socket);
        send = new ObjectOutputStream(localSocket.getOutputStream());
       recieved = new ObjectInputStream(localSocket.getInputStream());
    }

    /**
     * run the action of client
     */
    @Override
    public void run() {
        try {
            instanciationOfPlayer();
            uno = new Uno(playersOrg);
            writeClient();
            while (!uno.getCurrentPlayer().winGame()) {
                
                readClient();
                switch (msgClient.getStatus()) {
                    case CONNECT:
                        uno = new Uno(playersOrg);
                        break;
                    case PLAY:
                        uno.playCard(msgClient.getIndex(),msgClient.isCheck());
                        break;
                    case DRAWCARD:
                        uno.drawCard();
                        break;
                }

                writeClient();
            }
            localSocket.close();
           //serveurNetwork.closeSocket();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * adding a player and the bot (I.A)
     *
     * @throws IOException I/O exception
     * @throws ClassNotFoundException the ClassNotFoundException
     */
    private void instanciationOfPlayer() throws IOException,
            ClassNotFoundException {
         readClient();
        playersOrg = new ArrayList<>();
        Player player = new Player(0, msgClient.getName());
        Bot bot = new Bot(1, "bot");
        playersOrg.add(player);
        playersOrg.add(bot);
       
    }

    /**
     * reading of the stream received by the client
     *
     * @throws IOException I/O exception
     * @throws ClassNotFoundException the ClassNotFoundException
     */
    private void readClient() throws IOException, ClassNotFoundException {
        msgClient = (MessageClient) recieved.readObject();
        //serveurNetwork.readClient();
    }

    /**
     * sends server message to client
     *
     * @throws IOException I/O exception
     */
    private void writeClient() throws IOException {
        
        players = new ArrayList<>();
        playersOrg.forEach((p) -> {
            players.add(new PlayerC(p.getName(), p.getScore(),
                    p.getHands().size()));
        });
            send = new ObjectOutputStream(localSocket.getOutputStream());

        msgServeur = new MessageServeur(uno.getCurrentPlayer().winGame(),
                uno.getFlippedCard(), uno.getCurrentPlayer().getHands(), players);
        //serveurNetwork.writeClient(msgServeur);
        send.writeObject(msgServeur);
        send.flush();
    }

}
