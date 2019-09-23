
package g39801.uno.message.common;

import java.io.Serializable;

/**
 * communication of a message fromclient to the server
 * @author kamal
 */
public class MessageClient implements Serializable{
   private final static long serialVersionUID = 85L;
   private final String name;
   private final int index;
   private final Status status;
   private final boolean check;


   /**
    * the constructor creat a message sent to the server
    * @param name name of player
    * @param index the index of a card in the hand
    * @param status status of client
     * @param check
    */
    public MessageClient(String name, int index, Status status,boolean check) {
        this.name = name;
        this.index = index;
        this.status = status;
        this.check = check;
    }

    /**
     * return the name of player
     * @return the name of player
     */
    public String getName() {
        return name;
    }

    /**
     * return a position of a selected card
     * @return a position of a selected card
     */
    public int getIndex() {
        return index;
    }

    /**
     * return the status of the message sent to the server
     * @return the status of the message sent to the server
     */
    public Status getStatus() {
        return status;
    }

    public boolean isCheck() {
        return check;
    }



    
}
