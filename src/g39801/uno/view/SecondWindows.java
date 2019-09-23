/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.view;

import g39801.uno.bot.Bot;
import g39801.uno.model.Uno;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author kamal
 */
public class SecondWindows {

    BorderPane bdp;
    HBox hbox;
    VBox vbox;
    List<TextField> nameOfPlayer = new ArrayList<>();
    List<CheckBox> box = new ArrayList<>();
    Button btnOk;
    Uno uno;

    /**
     *
     * @param model
     * @param nbJoueur
     * @param bdp
     */
    public SecondWindows(Uno model, int nbJoueur, BorderPane bdp) {
        this.bdp = bdp;
        this.bdp.getChildren().clear();
        uno = model;

       
        vbox = new VBox(20);
        for (int i = 0; i < nbJoueur; i++) {
            
            Label player = new Label("name of player");
            TextField txt = new TextField();
            CheckBox bx = new CheckBox("humain");
            hbox = new HBox(30);

            hbox.setAlignment(Pos.CENTER);
            nameOfPlayer.add(txt);
            box.add(bx);
            hbox.getChildren().addAll(player, txt, bx);
            vbox.getChildren().add(hbox);
        }

        btnOk = new Button("next");
        btnOk.setAlignment(Pos.CENTER);
        vbox.getChildren().add(btnOk);
        bdp.setCenter(vbox);
    }

    /**
     *
     * @return the button
     */
    public Button getBtnOk() {
        return btnOk;
    }

    /**
     *
     * @return a list of chekBox
     */
    public List<CheckBox> getBox() {
        return box;
    }

    /**
     *
     * @return a list of name of player
     */
    public List<TextField> getNameOfPlayer() {
        return nameOfPlayer;
    }

}
