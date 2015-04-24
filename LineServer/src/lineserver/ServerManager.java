/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

import java.util.ArrayList;

/**
 *
 * @author myscloud
 */
public class ServerManager extends Thread {
    
    ArrayList<LineGroup> groups;
    ArrayList<ClientInfo> clients;
    
    @Override
    public void run(){
        
    }
    
    public void searchGroup(String searchQuery){
        ArrayList AnsGroupID = new ArrayList();
        ArrayList<String> AnsGroupName = new ArrayList<String> ();
        for(int i=0;i<groups.size();i++){
            if(searchQuery.equals(groups.get(i).groupName)){
                AnsGroupID.add(groups.get(i).groupId);
                AnsGroupName.add(groups.get(i).groupName);
            }
        }
    }
    
    public void addGroup(String groupName, ClientInfo[] clients){
        
    }
    
    public void addUser(String username){
        
    }
    
    public void logIn(String username){
        
    }
    
}
