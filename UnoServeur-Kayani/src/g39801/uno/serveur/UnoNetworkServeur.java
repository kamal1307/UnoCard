/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.serveur;

import g39801.uno.message.common.MessageClient;
import g39801.uno.message.common.MessageServeur;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author g39801
 */
public class UnoNetworkServeur {
    private final Socket localSocket;
    private MessageClient msgClient;
    private MessageServeur msgServeur;
    private ObjectOutputStream send;
    private final ObjectInputStream recieved;


    public UnoNetworkServeur(Socket socket) throws IOException {
       localSocket = socket;
       send = new ObjectOutputStream(localSocket.getOutputStream());
        recieved = new ObjectInputStream(localSocket.getInputStream());
    }
    
    public void readClient() throws IOException, ClassNotFoundException {
        msgClient = (MessageClient) recieved.readObject();
    }
    
      public void writeClient(MessageServeur msg) throws IOException {
        
    
      send = new ObjectOutputStream(localSocket.getOutputStream());

        send.writeObject(msg);
        send.flush();
    }
     
    public void closeSocket() throws IOException{
        localSocket.close();
    }
}
