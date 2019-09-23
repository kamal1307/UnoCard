package g39801.uno.client;

import g39801.uno.message.common.MessageClient;
import g39801.uno.message.common.MessageServeur;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * manage the network between client and server
 *
 * @author kamal
 */
class UnoNetworkClient {

    private final Socket localSocket;
    private final  ObjectOutputStream objOut;
    private  ObjectInputStream objIn;
    private final InputStream in ;
    private final OutputStream out;
    /**
     * the constructor initialize
     *
     * @param port connection port
     * @param ip address ip
     * @throws IOException I/O Exception
     */
    UnoNetworkClient(int port, String ip) throws IOException {
        localSocket = new Socket(ip, port);
        in = localSocket.getInputStream();
        out = localSocket.getOutputStream();
        objOut = new ObjectOutputStream(out);
        objIn = new ObjectInputStream(in);
    }

    /**
     * wrinting to server
     *
     * @param client message sending to server
     * @throws IOException I/O Exception
     */
    void writingServer(MessageClient client) throws IOException {
        objOut.writeObject(client);
        objOut.flush();

    }

    /**
     * reading from server
     *
     * @throws IOException I/O Exception
     * @throws ClassNotFoundException the ClassNotFoundException
     */
          MessageServeur readingServer() throws IOException, ClassNotFoundException {
        objIn=new ObjectInputStream(in);
        MessageServeur msgserv= (MessageServeur) objIn.readObject();
        return msgserv;
    }

}
