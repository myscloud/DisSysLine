/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineclient;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author myscloud
 */
class Sender extends Thread {

    private Socket serverSocket;
    private ObjectOutputStream out;
    private RemoteMessage remoteMessage;
    

    public Sender() {
        remoteMessage = new RemoteMessage();
    }
    
     public Sender(Socket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
        remoteMessage = new RemoteMessage();
        out = new ObjectOutputStream(serverSocket.getOutputStream());
    }

    public void run() {
        while (true) {
            synchronized (remoteMessage) {
                try {
                    remoteMessage.wait();
                    out.writeObject(remoteMessage.parameters);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void login(String username){
        String command = "login";
        ArrayList<String> params = new ArrayList<String>();
        params.add(username);
        System.out.println("client login");
        synchronized(remoteMessage){
            remoteMessage.setRemoteMessage(command, params);
        }
    }
    
    public void joinGroup(String groupName){
        String command = "joinGroup";
        ArrayList<String> params = new ArrayList<String>();
        params.add(groupName);
        synchronized(remoteMessage){
            remoteMessage.setRemoteMessage(command, params);
        }
    }
    
    public void askForGroupList(){
        String command = "askGroupList";
        ArrayList<String> params = new ArrayList<String>();
        System.out.println("ask for group list");
        synchronized(remoteMessage){
            remoteMessage.setRemoteMessage(command, params);
        }
    }
    
    public void enterGroup(String groupName){
        String command = "enterGroup";
        ArrayList<String> params = new ArrayList<>();
        params.add(groupName);
        synchronized(remoteMessage){
            remoteMessage.setRemoteMessage(command, params);
        }
    }
    
    public void sendMessage(String groupName, String message){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("d MMMM yyyy, HH.mm");
        String currentTime = format.format(date);
        
        String command = "sendMessage";
        ArrayList<String> params = new ArrayList<String>();
        params.add(groupName);
        params.add(message);
        params.add(currentTime);
        
        System.out.println("debug " + message);
        synchronized(remoteMessage){
            remoteMessage.setRemoteMessage(command, params);
        }
    }
    
    public void exitGroup(String groupName){
        String command = "exitGroup";
        ArrayList<String> params = new ArrayList<>();
        params.add(groupName);
        synchronized(remoteMessage){
            remoteMessage.setRemoteMessage(command, params);
        }
    }
    
    public void leaveGroup(String groupName){
        String command = "leaveGroup";
        ArrayList<String> params = new ArrayList<>();
        params.add(groupName);
        synchronized(remoteMessage){
            remoteMessage.setRemoteMessage(command, params);
        }
    }
}
