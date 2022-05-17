/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import resources.Utils;

/**
 * FXML Controller class
 *
 * @author eliotvg
 */
public class FXMLRegister implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button downloadAv;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private Button buttonLogIn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void ClickedOnregister(ActionEvent event) {
        
        
    }

    @FXML
    private void ClickedOnLogIn(ActionEvent event) throws IOException {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLlogin.fxml"));
        Parent root = loader.load();
        //AddController addController = loader.getController();

        //addController.addPerson(observableGuestList);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Log In");
        //stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();*/
        //buttonLogIn.getScene().getWindow().hide();
        Utils.changeScene(event, "/View/FXMLlogin.fxml", "Log In");
    }
    
}
