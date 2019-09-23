/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.view;

import g39801.uno.model.Uno;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

/**
 *
 * @author kamal
 */
public class FirstWindows {

    Uno uno;
    private final HBox hbox;
    private final VBox vbox;
    private final Label nbjoueur;
    private final Button btnOk;
    private final BorderPane bdp;
    private final ChoiceBox nombreJoueur;

    /**
     *
     * @param model
     */
    public FirstWindows(Uno model) {
        uno = model;
        bdp = new BorderPane();
        hbox = new HBox(30);
        hbox.setAlignment(Pos.CENTER);
        vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        nbjoueur = new Label("choose a number of player");
        nombreJoueur = new ChoiceBox(observableArrayList(2, 3,
                4, 5, 6, 7, 8, 9, 10));

        btnOk = new Button("next");

        hbox.getChildren().addAll(nbjoueur, nombreJoueur);
        vbox.getChildren().addAll(hbox, btnOk);
        bdp.setCenter(vbox);
        bdp.autosize();
    }

    /**
     *
     * @return
     */
    public Button getBtnOk() {
        return btnOk;
    }

    /**
     *
     * @return
     */
    public BorderPane getBdp() {
        return bdp;
    }

    /**
     *
     * @return
     */
    public ChoiceBox getNombreJoueur() {
        return nombreJoueur;
    }

}
