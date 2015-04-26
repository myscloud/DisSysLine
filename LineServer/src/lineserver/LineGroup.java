/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

//import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * UUID <------------------------------- unique id
 * @author myscloud
 */
public class LineGroup {
    int groupId;
    String groupName;
    ArrayList<LineUser> clientList;
    ArrayList<Integer> lastMessage; ///<clientID,messageID>
    ArrayList<Integer> clientStatus; //0 = exit, 1 = active
    ArrayList<Message> messageQueue;
    
    public LineGroup(int groupId, String groupName){
        this.groupId = groupId;
        this.groupName = groupName;
        
        clientList = new ArrayList<LineUser>();
        lastMessage = new ArrayList<Integer>();
        messageQueue = new ArrayList<Message>();
        clientStatus = new ArrayList<Integer>();
    }
    
    public void inviteUser(ClientInfo client){
        ///same with joinGroup
    }
    
    public void exitGroup(LineUser client){
        //maii yoo laew, diaw come back
        int idx = clientList.indexOf(client);
        clientStatus.set(idx, 0);
    }
    
    public void getLoginMessage(LineUser client){
        ///คืน arraylist ของ msg dee ma?
        ArrayList<Message> returnMSG = new ArrayList<Message> ();
        int startMSG_ID = this.lastMessage.get(client.id);
        int count=startMSG_ID;
        while(count!=messageQueue.size()){
            returnMSG.add(this.messageQueue.get(count));
            count++;
        }
    }
    
    public void addUserToGroup(LineUser client){
        if(clientList.contains(client)){
            System.out.print("ALREADY IN");
        }else{
            clientList.add(client);
        }
        lastMessage.add(0);
        clientStatus.add(0);
    }
    
    public void receiveMessage(Message message){
        messageQueue.add(message);
        sendNewMessage();
        printStatus();
    }
    
    public void sendNewMessage(){
        ArrayList<String> params = new ArrayList<String>();
        for(int i = 0; i < messageQueue.size(); i++){
            params.add(messageQueue.get(i).user.username);
            params.add(messageQueue.get(i).message);
            params.add(messageQueue.get(i).time);
            if(i != messageQueue.size()-1) params.add("0"); //old message
            else params.add("1");
        }
        
        for(int i = 0; i < clientList.size(); i++)
            if(clientStatus.get(i) == 1){
                lastMessage.set(i, messageQueue.size());
                ClientSender sender = clientList.get(i).currentSender;
                System.out.println("in line group -- " + params.get(0));
                sender.sendNewMessage(params);
            }
    }
    
    public ArrayList<String> getUnreadMessage(LineUser user){
        int idx = clientList.indexOf(user);
        int lastMsg = lastMessage.get(idx);
        ArrayList<String> params = new ArrayList<String>();
        for(int i = 0; i < messageQueue.size(); i++){
            params.add(messageQueue.get(i).user.username);
            params.add(messageQueue.get(i).message);
            params.add(messageQueue.get(i).time);
            if(i >= lastMsg) params.add("1"); //new message
            else params.add("0");
        }
        lastMessage.set(idx, messageQueue.size()); //reset last message
        return params;
    }
    
    public void leaveGroup(LineUser user){
        clientList.remove(user);
        lastMessage.remove(user);
        clientStatus.remove(user);
    }
    
    public void activeUser(LineUser user){
        int idx = clientList.indexOf(user);
        clientStatus.set(idx, 1);
        printStatus();
    }
    
    public int getNumberOfUnreadMessage(LineUser user){
        int idx = clientList.indexOf(user);
        if(idx != -1) return messageQueue.size() - lastMessage.get(idx);
        return -1;
    }
    
    public void printStatus(){
        System.out.println("===Message Queue===");
        for(int i = 0; i < messageQueue.size(); i++)
            System.out.println(messageQueue.get(i).message + " at " + messageQueue.get(i).time);
        System.out.println("=================");
        
        System.out.println("===Last Message Read===");
        for(int i = 0; i < clientList.size(); i++)
            System.out.println(clientList.get(i).username + " last read " + lastMessage.get(i));
        System.out.println("=================");
        
        System.out.println("===Client Status===");
        for(int i = 0; i < clientList.size(); i++)
            System.out.println(clientList.get(i).username + " status " + clientStatus.get(i));
        System.out.println("=================");
    }
}
