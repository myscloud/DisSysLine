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
    int id; //userID
    String username;
    public Socket socket;
    ArrayList<LineGroup> MyGroups;
    
    public void getGroupList(){
        for(int i=0;i<MyGroups.size();i++){
            int msgID = MyGroups.get(i).lastMessage.get(id);
            int numOfunread = MyGroups.get(i).lastMessage.size()-msgID;
            System.out.println(MyGroups.get(i).groupName+" :  "+numOfunread+" message(s) unread.");
        }
    }
    
    public void joinGroup(LineGroup group){
        MyGroups.add(group);
    }
    
    public void leaveGroup(LineGroup group){
            MyGroups.remove(group);
    }
}
