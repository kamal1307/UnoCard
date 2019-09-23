
 

package g39801.uno.bot;

import g39801.uno.model.Card;
import g39801.uno.model.Player;

/**
 *
 * @author g39801
 */
public class Bot extends Player{
    
    
    
    public Bot(int id, String name) {
        super(id, name);
    }
    
    @Override
    public int getCardPos(Card card){
        int i=0;
        Card cd=this.getHands().get(0);
        while (i<this.getHands().size() && !cd.compatible(card)) {            
            cd=this.getHands().get(i);       
            ++i;
        }
        
        if(i==this.getHands().size()){
            return -1;
        }else{
            return i;
        }
}
}
