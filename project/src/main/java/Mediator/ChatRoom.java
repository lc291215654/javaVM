package Mediator;

import java.util.Date;

/**
 * Created by licheng on 12/17/17.
 */
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}
