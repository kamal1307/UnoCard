/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g39801.uno.javaFx;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author kamal
 */
public class FirstWindows {

    private HBox hbox;
    private VBox vbox;
    private final Button btnOk;
    private BorderPane bdp;
    private Label name;
    private Label host;
    private Label port;
    private TextField txtName;
    private TextField txthost;
    private TextField txtPort;

    /**
     *
     *
     */
    public FirstWindows() {
        initializeHVBOX();
        initializeLabel();
        btnOk = new Button("next");
        hbox.getChildren().addAll(name, txtName, host, txthost, port, txtPort);
        vbox.getChildren().addAll(hbox, btnOk);
        bdp.setCenter(vbox);
        bdp.autosize();
    }

    /**
     * initialize hbox and vbox
     */
    private void initializeHVBOX() {
        bdp = new BorderPane();
        hbox = new HBox(30);
        hbox.setAlignment(Pos.CENTER);
        vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
    }

    /**
     * initialize label
     */
    private void initializeLabel() {

        name = new Label("Name : ");
        txtName = new TextField();
        host = new Label("Host : ");
        txthost = new TextField();
        port = new Label("Port : ");
        txtPort = new TextField();
    }

    /**
     * return string name
     *
     * @return string name
     */
    public String getTxtName() {
        return txtName.getText();
    }

    /**
     * return string host
     *
     * @return string host
     */
    public String getTxthost() {
        return txthost.getText();
    }

    /**
     * return string port
     *
     * @return string port
     */
    public String getTxtPort() {
        return txtPort.getText();
    }

    /**
     *
     * @return button
     */
    public Button getBtnOk() {
        return btnOk;
    }

    /**
     *
     * @return borderpane
     */
    public BorderPane getBdp() {
        return bdp;
    }

}
