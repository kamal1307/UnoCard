/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * contain the management of multi-client server
 * @author g39801
 */
public class UnoServeur {

    public static void main(String[] args) {
        UnoServeur server = new UnoServeur(50000);
        server.listening();
    }

    private final boolean status;
    private final int port;

    /**
     * the constructor creat a server with a listenning port
     * @param port port for connection
     */
    public UnoServeur(int port) {
        this.port = port;
        this.status = true;
    }

    /**
     * waits for a client connection
     */
    public void listening() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
             while (status) {
                System.out.println("Serveur listening ... ");
                Socket localSocket = serverSocket.accept();
                new ThreadClient(localSocket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error listening () " + ex.getMessage());
        }
    }

}
