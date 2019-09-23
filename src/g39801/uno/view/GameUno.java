package g39801.uno.view;

import g39801.uno.bot.Bot;
import g39801.uno.model.Uno;
import g39801.uno.model.Player;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * contains the start game
 *
 * @author kamal
 */
public class GameUno extends Application {

    private Uno uno;
    private BorderPane root;
    private FirstWindows v1;
    private SecondWindows v2;
    private ThirdWindows v3;
    private List<Player> player;

    /**
     * the constructor initialize the BorderPane and the first window
     */
    public GameUno() {
        root = new BorderPane();
        // v1 = new FirstWindows(uno);
        // root = v1.getBdp();   reprend ici kams
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        launch(args);

    }

    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("UNO");
        v1 = new FirstWindows(uno);
        root = v1.getBdp();
        v1.getBtnOk().setOnAction((ActionEvent event) -> {
            int nbPlayer = (int) v1.getNombreJoueur().getSelectionModel().getSelectedItem();
            v2 = new SecondWindows(uno, nbPlayer, root);

            v2.getBtnOk().setOnAction((ActionEvent event1) -> {
                int cpt = 0;
                player = new ArrayList<>();
                
                for(int i=0;i<v2.getNameOfPlayer().size();i++){
                    TextField text=v2.getNameOfPlayer().get(i);
                    if(!v2.getBox().get(i).isSelected()){
                        player.add(new Bot(cpt, text.getText()));
                        
                    }else{
                        player.add(new Player(cpt, text.getText()));
                    }
                    cpt++;
                }
//                
//                for (TextField text : v2.getNameOfPlayer()) {
//                   
//                    player.add(new Player(cpt, text.getText()));
//                    
//                }
//                 Bot b1=new Bot(1,"bot1");Bot b2=new Bot(2,"bot2");
//                 player.add(b1);
//                 player.add(b2);
                 
                uno = new Uno(player);
                v3 = new ThirdWindows(uno, root);
            });
        });

        Scene scene = new Scene(root, 800, 800,Color.AQUA);
        primaryStage.setScene(scene);
       
        
        primaryStage.show();

    }
}
