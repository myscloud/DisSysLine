/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

//import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

/**
 * UUID <------------------------------- unique id
 * @author myscloud
 */
public class LineGroup {
    public String groupName;
    public int groupId;
    public ArrayList<User> users;
    
    public ArrayList<Message> messages;
    LineServer mainServer ;

    public LineGroup(String groupName){
        LocalDateTime timeNow= LocalDateTime.now();
        this.groupId= mainServer.groups.size()+1;
        this.groupName=groupName;
    }
    public void addUser(User usr){
        if(users.contains(usr)){
            System.out.println("THE USER ALREADY EXIST");
        }else{
            users.add(usr);
        }
    }
    public void delUser(User usr){
        if(users.contains(usr)){
            users.remove(usr);
        }else{
            System.out.println("THE USER DOESN'T EXIT");
        }
    }
    public void AUTOgetMessage(User usr){
        
    }
    public void LOGINgetMessage(){
        //send message since lastMessage[usr]

    }
    
    //************************new functions start here************************
    ArrayList<ClientInfo> clients;
    public Map<Integer, Integer> lastMessage;
    ArrayList<Message> messageQueue;
    
    public void inviteUser(ClientInfo client){
        
    }
    
    public void exitGroup(ClientInfo client){
        
    }
    
    public void getLoginMessage(ClientInfo client){
        
    }
    
    public void joinGroup(ClientInfo client){
        
    }
    
    public void sendMessage(ClientInfo client, Message message){
        
    }
    
    public void leaveGroup(ClientInfo client){
        
    }
    
}
