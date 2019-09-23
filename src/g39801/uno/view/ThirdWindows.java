/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.view;

import g39801.uno.bot.Bot;
import g39801.uno.model.Card;
import java.util.Observer;
import g39801.uno.model.Uno;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author kamal
 */
public class ThirdWindows implements Observer {

    private final Uno uno;
    private final BorderPane bdp;

    private List<CardView> listImage;
    private Button b1;
    private Button b2;

    /**
     *
     * @param model
     * @param bp
     */
    public ThirdWindows(Uno model, BorderPane bp) {
        model.addObserver(this);
        uno = model;
        bdp = bp;
        bdp.getChildren().clear();
        listImage = new ArrayList();

        update(null, null);
        if(model.getCurrentPlayer().getClass()==Bot.class){
            model.playCard(model.getCurrentPlayer().getCardPos(model.getFlippedCard()));
        }

    }

    /**
     * display the name of player and this score
     */
    private void displayInfoPlayer() {
        Group group = new Group();
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        HBox hbox2 = new HBox();
        HBox hbox3 = new HBox();

        for (int i = 0; i < uno.getNbPlayers(); i++) {

            Text text = new Text("Name of Player");

            Text text2 = new Text(uno.getPlayer(i).getName());
            if (uno.getCurPlayer() == i) {
                text2.setText("-->" + uno.getPlayer(i).getName() + "<--");
            }

            Text text3 = new Text("Score of Player :");
            Text text4 = new Text(uno.getPlayer(i).getScore() + "");
            Text text5 = new Text("hand: ");

            Text text6 = new Text(Integer.toString(uno.getPlayer(i).handSize()));
            hbox.getChildren().addAll(text, text2);
            hbox.setSpacing(8);
            hbox2.getChildren().addAll(text3, text4);
            hbox2.setSpacing(8);
            hbox3.getChildren().addAll(text5, text6);

        }
        hbox3.setSpacing(8);
        hbox.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(hbox, hbox2, hbox3);
        vbox.setSpacing(8);

        group.getChildren().add(vbox);
        bdp.setTop(group);
    }

    /**
     * display the deck on the table
     */
    private void displayDeck() {
        Group group = new Group();
        VBox vBox = new VBox();
        ImageView image = new ImageView("g39801/uno/unoValCards/back.png");

        b2 = new Button("piocher carte");

        b2.setOnAction((ActionEvent e) -> {
            uno.drawCard();
       
        });
        image.setFitHeight(150);
        image.setFitWidth(150);
        group.getChildren().add(vBox);
        vBox.getChildren().addAll(image, b2);
        vBox.setSpacing(8);
        bdp.setLeft(group);
    }

    /**
     * display the defause card on the table
     */
    private void displayDefause() {
        Group group = new Group();
        VBox vbox = new VBox();

        group.getChildren().add(vbox);

        vbox.setSpacing(8);
        vbox.getChildren().add(getImage(uno.getFlippedCard()));

        bdp.setCenter(group);
    }

    /**
     * return the index of the card selected
     *
     * @return the index of the card selected
     */
    private int indexSelected() {
        int index = 0;
        for (int i = 0; i < listImage.size(); i++) {
            if (listImage.get(i).isSelected()) {
                index = i;
                break;

            }
        }
        return index;
    }

    /**
     * display the hand of player
     *
     * @param cards the list of cards
     */
    private void displayHandPlayer(List<Card> cards) {
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        HBox hbox2 = new HBox();
        ScrollPane scroll = new ScrollPane(hbox);

        b1 = new Button("deposer Carte");
        b1.setOnAction((ActionEvent e) -> {
            int index = indexSelected();          
                uno.playCard(index);
                if (uno.getCurrentPlayer().getHands().isEmpty()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("erreur");
                    alert.setContentText("le joueur :" + uno.getCurrentPlayer() + " a gagné la parti");

                    alert.showAndWait();
                }
            
        });

        hbox2.getChildren().add(b1);
        hbox2.setAlignment(Pos.CENTER);
        hbox.setSpacing(5);

        for (int i = 0; i < cards.size(); i++) {
            listImage.add(getImage(cards.get(i)));
        }

        for (int j = 0; j < cards.size(); j++) {
            hbox.getChildren().add(listImage.get(j));
        }
        hbox.setSpacing(8);

        vbox.getChildren().addAll(scroll, hbox2);
        bdp.setBottom(vbox);
    }

    /**
     * return the card image which corresponds to the card received
     *
     * @param card the card to convert in the card image
     * @return the card image which corresponds to the card received
     */
    private CardView getImage(Card card) {
        CardView image;
        if (null == card.getColor()) {
            image = new CardView("g39801/uno/unoValCards/g" + card.getValue().getValue() + ".png");
        } else {
            switch (card.getColor()) {
                case RED:
                    image = new CardView("g39801/uno/unoValCards/r" + card.getValue().getValue() + ".png");
                    break;
                case YELLOW:
                    image = new CardView("g39801/uno/unoValCards/y" + card.getValue().getValue() + ".png");
                    break;
                case BLUE:
                    image = new CardView("g39801/uno/unoValCards/b" + card.getValue().getValue() + ".png");
                    break;
                default:
                    image = new CardView("g39801/uno/unoValCards/g" + card.getValue().getValue() + ".png");
                    break;
            }
        }

        image.setFitHeight(150);
        image.setFitWidth(150);

        return image;
    }

    /**
     * update all information about the player, the deck, the defause card and
     * the hand of player
     *
     * @param o
     * @param arg
     */
    @Override
    public final void update(Observable o, Object arg) {
        bdp.getChildren().clear();
        listImage = new ArrayList();

        displayInfoPlayer();
        displayDeck();
        displayDefause();
        displayHandPlayer(uno.getCurrentPlayer().getHands());
        System.out.println(uno.getCurrentPlayer().getName());

        if (uno.getCurrentPlayer().winGame()) {
            System.out.println("fin gu game");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("win game");
            alert.setContentText("le joueur :" + uno.getCurrentPlayer().getName() + " a gagné la parti");

            alert.showAndWait();

            Platform.exit();
            System.exit(0);
        }
    }

}
