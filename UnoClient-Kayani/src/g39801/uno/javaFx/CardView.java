/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.javaFx;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author g39801
 */
public class CardView extends ImageView {

    private boolean selected;
    private int cpt;

    /**
     *
     * @param lien the path of the name of the card
     */
    public CardView(String lien) {
        super(lien);
        cpt = 1;
        earphoneOfMouse();

    }

    /**
     * return if the card is select or not
     *
     * @return if the card is select or not
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * display the transparency if a card is selected
     */
    private void earphoneOfMouse() {
        this.setOnMouseClicked((MouseEvent event) -> {
            if ((cpt % 2) == 0) {
                setStyle("-fx-opacity:1");
                selected = false;
                cpt++;
            } else {
                setStyle("-fx-opacity:0.4");
                selected = true;
                cpt++;

            }
        });
    }
}
