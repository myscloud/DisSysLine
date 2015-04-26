/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;

/**
 *
 * @author Earth_MacBook
 */

public class LineClient{
    
    public static final String SERVER_HOSTNAME = "localhost";
    public static final int SERVER_PORT = 9999;

    public static void main(String args[]){
        
        Sender sender = null;
        Receiver receiver = null;
        
        try {           
           Socket socket = new Socket(SERVER_HOSTNAME, SERVER_PORT);
           System.out.println("Connected to server " +
              SERVER_HOSTNAME + ":" + SERVER_PORT);
           
           sender = new Sender(socket);
           receiver = new Receiver(socket);
           
           //GUI
           Login mainFrame = new Login(sender, receiver);
           receiver.setMainPage(mainFrame);
           
           sender.start();
           receiver.start();
            
        } catch (IOException ioe) {
           System.err.println("Can not establish connection to " +
               SERVER_HOSTNAME + ":" + SERVER_PORT);
           ioe.printStackTrace();
           System.exit(1);
        }

   }
}