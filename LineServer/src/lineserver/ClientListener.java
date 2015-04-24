/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author myscloud
 */
public class ClientListener extends Thread {
    private ServerManager serverManager;
    private ClientInfo client;
    private BufferedReader reader;
 
    public ClientListener(ClientInfo aClientInfo, ServerManager aServerManager)
    throws IOException
    {
        client = aClientInfo;
        serverManager = aServerManager;
        Socket socket = client.socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
 
    /**
     * Until interrupted, reads messages from the client socket, forwards them
     * to the server dispatcher's queue and notifies the server dispatcher.
     */
    public void run()
    {
        try {
           while (!isInterrupted()) {
               String message = reader.readLine();
               if (message == null)
                   break;
               mServerDispatcher.dispatchMessage(mClientInfo, message);
           }
        } catch (IOException ioex) {
           // Problem reading from socket (communication is broken)
        }
 
        // Communication is broken. Interrupt both listener and sender threads
        client.mClientSender.interrupt();
        mServerDispatcher.deleteClient(mClientInfo);
    }
    
    public void extractRemoteMessage(){
        
    }
}
