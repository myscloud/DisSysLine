/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

import java.time.LocalDateTime;

/**
 *
 * @author myscloud
 */
public class LineServerThread {
    public LineServer lineServer;
    public LineServerThread(LineServer lineServer){
        this.lineServer = lineServer;
    }
    
    
    public void receiveMessage(RequestMessage incomingMsg){
        String reqM = incomingMsg.reqType;
        int userId = incomingMsg.userId;
        int groupId = incomingMsg.groupId;
        String message = incomingMsg.message;
        LocalDateTime time = incomingMsg.time;
        
        
        if(reqM.equals("login")){
          
        }
        if(reqM.equals("createGroup")){
            User u = lineServer.users.get(userId);
            u.createGroup(message); //New group's name
        }
        if(reqM.equals("joinGroup")){ //message=desired group
            User u = lineServer.users.get(userId);
            u.joinGroup(Integer.parseInt(message));
        }
        if(reqM.equals("searchGroup")){
            User u =lineServer.users.get(userId);
            u.searchGroup(message);
        }
        if(reqM.equals("inviteUser")){
            User u = lineServer.users.get(userId);
            u.inviteUser(Integer.parseInt(message), groupId);
        }
        if(reqM.equals("exitGroup")){
            User u =lineServer.users.get(userId);
            u.exitGroup();
        }
        if(reqM.equals("getGroupList")){
            
        }
        if(reqM.equals("getLoginMessage")){
            
        }
           
        /*  (reqType)
            login
            createGroup
            joinGroup
            inviteUser
            searchGroup
            sendMessage
            leaveGroup
            exitGroup
            getGroupList
            getLoginMessage
        */
        //this method 
    }
    
    
    public void addGroup(){
        
    }
    
    public void leaveGroup(){
    
    }
    
    public void addPeopleToGroup(){
    
    }
    
    public void getUnreadMessage(){
    
    }
}
