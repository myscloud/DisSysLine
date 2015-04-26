/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author myscloud
 */
public class ClientInfo {
    LineUser user;
    public Socket socket;
    ArrayList<LineGroup> MyGroups;
    
    ClientListener listener;
    ClientSender sender;
    
    public ClientInfo(){
        
    }
    
    public void setDefault(Socket socket, ClientListener listener, ClientSender sender){
        this.socket = socket;
        this.listener = listener;
        this.sender = sender;
        user = null;
    }

    public void setUser(LineUser user){
        this.user = user;
    }
}
