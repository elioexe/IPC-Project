/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import DBAccess.NavegacionDAOException;
import model.Navegacion;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import resources.Utils;
import controller.FXMLMenuPrincipall;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author eliotvg
 */

// color background #FAEBD7

public class FXMLloginController implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private TextField passWord;
    @FXML
    private Button buttonLogIn;
    @FXML
    private Button buttonSignUp;
    
    private Navegacion navegacion;
    
    private User player;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            navegacion = Navegacion.getSingletonNavegacion();
            
            //LocalDate ldObj = LocalDate.of(1999, 11, 6);
            //navegacion.registerUser("David11", "david11@wanadoo.fr", "DAVID11$$david", ldObj);
        } catch (NavegacionDAOException ex) {
            Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }    
    
    private boolean checkValidInf(){
        String user = userName.textProperty().getValueSafe();
        String pswd = passWord.textProperty().getValueSafe();
        if (true){
            /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("IINFORMATION");
            alert.setHeaderText("Wrong user name");
            //alert.setContentText("Has comprado en " );
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();*/
            return false;
        }else {
            return true;
        }
        
    }
    

    @FXML
    private void OnclickedLogIn(ActionEvent event) throws IOException {
        String user = userName.textProperty().getValueSafe();
        String pswd = passWord.textProperty().getValueSafe();
        User isExist = navegacion.loginUser(user, pswd);
        if(!navegacion.exitsNickName(user)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("IINFORMATION");
            alert.setHeaderText("Username not existing");
            //alert.setContentText("Has comprado en " );
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
            return;
        }else if (isExist == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("IINFORMATION");
            alert.setHeaderText("wrong password");
            //alert.setContentText("Has comprado en " );
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
            return;
        }else {
            player = isExist;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLMenuPrincipal.fxml"));
            Parent root = loader.load();
            FXMLMenuPrincipall addController = loader.getController();

            addController.initData(navegacion,player);
            Stage stage=new Stage();
            stage.setTitle("Menu");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
            buttonLogIn.getScene().getWindow().hide();
            
        }
        
        
    }

    @FXML
    private void OnclikedSignUp(ActionEvent event) throws IOException {
        /*Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLRegister.fxml"));     
        Scene scene = new Scene(root);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();*/
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLRegister.fxml"));
        Parent root = loader.load();
       
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Register");
        
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();*/
        
        Utils.changeScene(event, "/View/FXMLRegister.fxml", "Register");
        //Utils.changeScene(event,"/View/FXMLRegister.fxml","Register");

    }
    
}
