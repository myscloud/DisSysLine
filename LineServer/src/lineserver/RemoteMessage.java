/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author myscloud
 */
public class RemoteMessage implements Serializable {
    ArrayList<String> parameters;
    
    public RemoteMessage(){
        parameters = new ArrayList<String>();
    }
    
    public void setRemoteMessage(String command, ArrayList<String> parameters){
        synchronized(this){
            this.parameters.clear();
            this.parameters = parameters;
            this.parameters.add(0, command);
            this.notify();
        }
    }
}
