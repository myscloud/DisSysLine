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
public class LineGroup {
    public int groupId;
    public String groupName;
    public ArrayList<User> users;
    public ArrayList<User> lastMessage;
    public ArrayList<Message> messages;

    public LineGroup(int groupId, String groupName){
        this.groupId=groupId;
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