/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author myscloud
 */
public class LineGroup {
    public String groupName;
    public int groupId;
    public ArrayList<User> users;
    public ArrayList<User> lastMessage;
    public ArrayList<Message> messages;

    public LineGroup(String groupName){
        LocalDateTime timeNow= LocalDateTime.now();
        this.groupId= timeNow.getNano()*timeNow.getHour();
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
    
}
