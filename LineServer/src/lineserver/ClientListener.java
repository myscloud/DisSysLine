/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author myscloud
 */
public class ClientListener extends Thread {

    private ServerManager manager;
    private ClientInfo client;
    private ClientSender sender;
    private ObjectInputStream in;
    private Socket socket;
    
    private LineGroup currentGroup;

    public ClientListener(ClientInfo client, ServerManager manager, ClientSender sender, Socket socket) throws IOException {
        this.client = client;
        this.manager = manager;
        this.sender = sender;
        this.socket = socket;
        in = new ObjectInputStream(socket.getInputStream());
        currentGroup = null;
    }

    @Override
    public void run() {
        ArrayList<String> parameters;
        int count = 0;
        while (count < 10) {
            try {
                if ((parameters = (ArrayList<String>)in.readObject()) != null) {
                    extractRemoteMessage(parameters);
                    System.out.println("server: receive " + parameters.get(0));
                }
            } catch (IOException ex) {
                //System.out.println("io exception");
                //Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, ex);
                count++;
            } catch (ClassNotFoundException ex) {
                //System.out.println("class not found");
                //Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, ex);
                count++;
            }
        }
    }

    public boolean extractRemoteMessage(ArrayList<String> message) {
        String command = message.get(0);
        if(command.equals("login")){
            client.user = manager.logIn(message.get(1));
            client.user.setCurrentSender(sender);
            System.out.println("checkkkk " + client.user.username);
            ArrayList<String> params = client.user.getGroupList();
            sender.sendGroupList(params);
        }
        else if(command.equals("joinGroup")){
            LineGroup group = manager.joinGroup(message.get(1));
            client.user.joinGroup(group);
            group.addUserToGroup(client.user);
        }
        else if(command.equals("askGroupList")){
            sendGroupList();
        }
        else if(command.equals("sendMessage")){
            Message sentMessage = new Message(client.user, message.get(2), message.get(3));
            currentGroup.receiveMessage(sentMessage);
        }
        else if(command.equals("enterGroup")){
            currentGroup = manager.findGroup(message.get(1));
            currentGroup.activeUser(client.user);
            ArrayList<String> params = currentGroup.getUnreadMessage(client.user);
            sender.sendUnreadMessage(params);
        }
        else if(command.equals("exitGroup")){
            currentGroup.exitGroup(client.user);
            currentGroup = null;
            sendGroupList();
        }
        else if(command.equals("leaveGroup")){
            currentGroup.leaveGroup(client.user);
            client.user.leaveGroup(currentGroup);
            currentGroup = null;
            sendGroupList();
        }
        return false;
    }
    
    public void sendGroupList(){
        ArrayList<String> params = client.user.getGroupList();
        sender.sendGroupList(params);
    }
}
