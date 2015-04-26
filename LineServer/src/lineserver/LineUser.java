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
public class LineUser {

    int id;
    String username;
    ArrayList<LineGroup> MyGroups;
    ClientSender currentSender;

    public LineUser() {

    }

    public LineUser(int id, String username) {
        this.id = id;
        this.username = username;
        
        MyGroups = new ArrayList<LineGroup>();
    }

    public ArrayList<String> getGroupList() {
        ArrayList<String> params = new ArrayList<String>();
        for (int i = 0; i < MyGroups.size(); i++) {
            LineGroup group = MyGroups.get(i);
            String groupName = group.groupName;
            int numOfUnread = group.getNumberOfUnreadMessage(this);
            params.add(groupName);
            params.add(Integer.toString(numOfUnread));
        }
        return params;
    }

    public void joinGroup(LineGroup group) {
        if(!MyGroups.contains(group)){
            MyGroups.add(group);
            System.out.println("in user: " + MyGroups.get(0).groupName);
        }
        else{
            System.out.println("already in");
        }
    }
    
    public void setCurrentSender(ClientSender sender){
        currentSender = sender;
    }

    public void leaveGroup(LineGroup group) {
        MyGroups.remove(group);
    }
}
