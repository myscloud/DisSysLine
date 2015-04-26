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
    ArrayList<LineUser> clients;
    
    public ServerManager(){
        groups = new ArrayList<LineGroup>();
        clients = new ArrayList<LineUser>();
    }
    
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
    
    public LineGroup addGroup(String groupName){
        LineGroup group = new LineGroup(groups.size(), groupName);
        groups.add(group);
        System.out.println("add "+groups.get(0).groupName);
        return group;
    }
    
    public LineGroup joinGroup(String groupName){
        LineGroup group = null;
        System.out.println("debug " + groupName);
        for(int i = 0; i < groups.size(); i++){
            if(groups.get(i).groupName.equals(groupName)){
                group = groups.get(i);
                break;
            }
        }
        if(group == null)
            group = addGroup(groupName);
        
        System.out.println("------user-------");
        for(int i = 0; i < groups.size(); i++)
            System.out.println(groups.get(i).groupName);
        System.out.println("------user-------");
        return group;
    }
    
    public LineUser addUser(String username){
        LineUser user = new LineUser(clients.size(), username);
        clients.add(user);
        return user;
    }
    
    public LineUser logIn(String username){
        LineUser user = null;
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).username.equals(username)){
                user = clients.get(i);
                break;
            }
        }
        if(user == null)
            user = addUser(username);
        return user;
    }
    
    public LineGroup findGroup(String groupName){
        LineGroup group = null;
        for(int i = 0; i < groups.size(); i++){
            if(groups.get(i).groupName.equals(groupName)){
                group = groups.get(i);
            }
        }
        return group;
    }
}
