/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 *
 * @author myscloud
 */
public class Receiver extends Thread {
    
    private Login mainPage;
    Socket socket;
    ObjectInputStream in;
    
    public Receiver(Socket socket) throws IOException{
        this.socket = socket;
        this.mainPage = mainPage;
        in = new ObjectInputStream(socket.getInputStream());
    }
    
    public void run(){
        ArrayList<String> parameters;
        int count = 0;
        while (count < 10) {
            try {
                if ((parameters = (ArrayList<String>)in.readObject()) != null) {
                    System.out.println("client: receive " + parameters.get(0));
                    extractRemoteMessage(parameters);
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
    
    public void setMainPage(Login mainPage){
        this.mainPage = mainPage;
    }
    
    void extractRemoteMessage(ArrayList<String> message){
        String command = message.get(0);
        if(command.equals("sendGroupList")){
            mainPage.mainPage.setGroupPanels(message);
        }
        else if(command.equals("sendNewMessage")){
            System.out.println("======NEW MESSAGE=======");
            for(int i = 0; i < message.size(); i++){
                System.out.println(i+" "+message.get(i));
            }
            mainPage.chatPage.receiveMessage(message);
        }
        else if(command.equals("sendUnreadMessage")){
            System.out.println("======UNREAD MESSAGE=======");
            for(int i = 0; i < message.size(); i++){
                System.out.println(i+" "+message.get(i));
            }
            mainPage.chatPage.receiveMessage(message);
        }
    }
    
}
