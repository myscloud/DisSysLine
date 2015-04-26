/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author myscloud
 */
public class ClientSender extends Thread {
    
    private ServerManager manager;
    private ClientInfo client;
    private ObjectOutputStream out;
    private Socket socket;
    
    private RemoteMessage remoteMessage;
 
    public ClientSender(ClientInfo client, ServerManager manager, Socket socket)
    throws IOException
    {
        this.client = client;
        this.manager = manager;
        out = new ObjectOutputStream(socket.getOutputStream());
        remoteMessage = new RemoteMessage();
    }

    /**
     * Until interrupted, reads messages from the message queue
     * and sends them to the client's socket.
     */
    @Override
    public void run()
    {
        while(true){
            synchronized(remoteMessage){
                try {
                    remoteMessage.wait();
                    out.writeObject(remoteMessage.parameters);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ClientSender.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ClientSender.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void sendGroupList(ArrayList<String> params){
        remoteMessage.setRemoteMessage("sendGroupList", params);
    }
    
    public void sendNewMessage(ArrayList<String> params){
        remoteMessage.setRemoteMessage("sendNewMessage", params);
    }
    
    public void sendUnreadMessage(ArrayList<String> params){
        remoteMessage.setRemoteMessage("sendUnreadMessage", params);
    }
}
