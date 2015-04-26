/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author myscloud
 */
public class LineServer {

    /**
     * @param args the command line arguments
     */
    public static final int LISTENING_PORT = 9999;

    public static void main(String[] args) throws IOException {
        // Open server socket for listening
        ServerSocket serverSocket = null;
        ServerManager manager = new ServerManager();
        try {
            serverSocket = new ServerSocket(LISTENING_PORT);
            System.out.println("NakovChatServer started on port " + LISTENING_PORT);
        } catch (IOException se) {
            System.err.println("Can not start listening on port " + LISTENING_PORT);
            se.printStackTrace();
            System.exit(-1);
        }
        
        //wait for client connection
        while(true){
            Socket newSocket = serverSocket.accept();
            ClientInfo client = new ClientInfo();
            ClientSender sender = new ClientSender(client, manager, newSocket);
            ClientListener listener = new ClientListener(client, manager, sender, newSocket);
            client.setDefault(newSocket, listener, sender);
            
            listener.start();
            sender.start();
        }
    }
}
