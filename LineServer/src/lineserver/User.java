/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date.*;
import java.util.ArrayList;

/**
 *
 * @author myscloud
 */
public class User {
    public ArrayList<LineGroup> groups; //Groups that user are in
    public int userId;
    LineServer mainServer;
    
    
    public void sendMessage(String message,int groupId){
        Message msg = new Message();
        msg.message=message;
        msg.userId=this.userId;
        msg.time= LocalDateTime.now();
        msg.groupId=groupId;
    }
    public void leaveGroup(LineGroup grp){
        if(groups.contains(grp)){
            groups.remove(grp);
        }else{
            System.out.println("YOU ARE NOT IN THIS GROUP");
        }
    }
    public void joinGroup(LineGroup grp){
        if(groups.contains(grp)){
            System.out.println("ALREADY JOINED");
        }else{
            groups.add(grp);
        }
    }
    public void inviteUser(LineGroup grp, User usr){
        if(grp.users.contains(this)){
            if(grp.users.contains(usr)){
                System.out.println("THIS USER ALREADY JOINED");
            }else{
                grp.users.add(usr);
            }
        }else{
            System.out.println("YOU HAVE NO RIGHT");
        }
    }
    public void createGroup(String groupName, int groupId){
        LineGroup tmpGroup;
        tmpGroup.groupId=groupId;
        tmpGroup.groupName=groupName;
        mainServer.groups.add(tmpGroup;
    }
    public void searchGroup(String query){
        mainServer.groups
    }
    
}
