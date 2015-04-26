/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineserver;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
/**
 *
 * @author myscloud
 */
public class Message {
    LineUser user;
    String message;
    String time;
    
    public Message(LineUser user, String message, String time){
        this.user = user;
        this.message = message;
        this.time = time;
    }
}
