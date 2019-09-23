/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.bot;

import g39801.uno.modelCommon.CardC;
import g39801.uno.model.Player;

/**
 * contain the I.A
 * @author kamal
 */
public class Bot extends Player{
    
    
    /**
     * the constructor initialize a I.A
     * @param id index of bot player
     * @param name name of bot
     */
    public Bot(int id, String name) {
        super(id, name);
    }
    
    /**
     * 
     * @param card the defause card
     * @return the index card who is compatible with the defause card
     */
    @Override
    public int getCardPos(CardC card){
        int i=0;
        CardC cd=this.getHands().get(0);
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
