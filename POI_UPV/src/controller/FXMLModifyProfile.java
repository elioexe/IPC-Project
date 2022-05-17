/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import model.Navegacion;
import model.Session;
import model.User;

/**
 * FXML Controller class
 *
 * @author eliotvg
 */
public class FXMLModifyProfile implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private DatePicker dateOfBirth;
    
    private Navegacion navegacion;
    
    private User player;
    
    private File avatar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ClickedOneditChange(ActionEvent event) {
        
        
    }
    
    
    
    public void initData(Navegacion na, User plyr){
        userName.setText(plyr.getNickName());
        email.setText(plyr.getEmail());
        password.setText(plyr.getPassword());
        dateOfBirth.setValue(plyr.getBirthdate()); 
        navegacion = na;
        player = plyr;
        
    }

    @FXML
    private void fileChose(ActionEvent event) {
        FileChooser fc =new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files","*.png"));
        File f = fc.showOpenDialog(null);
        
        if(f != null){
            avatar = f;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
            alert.setHeaderText("Your avatar has been choosen");
            //alert.setContentText("Has comprado en " );
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
            alert.setHeaderText("Your avatar has not been into account");
            //alert.setContentText("Has comprado en " );
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
        }
    }
    
}
