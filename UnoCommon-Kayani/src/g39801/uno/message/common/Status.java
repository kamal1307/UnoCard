
package g39801.uno.message.common;

import java.io.Serializable;

/**
 * informs about the type of message exchanged
 * @author kamal
 */
public enum Status implements Serializable{
    /**
     * message connection
     */
    CONNECT,
    /**
     * message play a card
     */
    PLAY,
    /**
     * message draw a card
     */
    DRAWCARD,
    
    CHECK,
}
