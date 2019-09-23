package g39801.uno.javaFx;

import g39801.uno.client.UnoClient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * contains the start game
 *
 * @author kamal
 */
public class GameUno extends Application {

    private UnoClient unoClient;
    private BorderPane root;
    private FirstWindows v1;

    private ThirdWindows v3;
    /**
     * the constructor initialize the BorderPane and the first window
     */
    public GameUno() {
//        root = new BorderPane();
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
        root = new BorderPane();
        v1 = new FirstWindows();
        root = v1.getBdp();

        v1.getBtnOk().setOnAction((ActionEvent event) -> {
            try {
                String name = v1.getTxtName();
                int port;
                String host;
                host = v1.getTxthost();
                if (host.isEmpty()) {
                    host = "127.0.0.1";
                }
                if (v1.getTxtPort().isEmpty()) {
                    port = 50000;
                } else {
                    port = Integer.parseInt(v1.getTxtPort(), 10);
                    
                }
                
                unoClient = new UnoClient(host, port);
                unoClient.play(name);
                
                v3 = new ThirdWindows(unoClient, root);
            } catch (IOException ex) {
                Logger.getLogger(GameUno.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Scene scene = new Scene(root,800, 800, Color.AQUA);
        primaryStage.setScene(scene);

        primaryStage.show();

    }
}
