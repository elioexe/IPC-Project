/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import DBAccess.NavegacionDAOException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Navegacion;
import model.User;
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
    private DatePicker dateOfBirth;
    @FXML
    private Button buttonLogIn;
    
    private Navegacion navegacion;
    
    private User player;
    
    private File avatar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // TODO
            navegacion = Navegacion.getSingletonNavegacion();
            
            //LocalDate ldObj = LocalDate.of(1999, 11, 6);
            //navegacion.registerUser("David11", "david11@wanadoo.fr", "DAVID11$$david", ldObj);
        } catch (NavegacionDAOException ex) {
            Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    

    @FXML
    private void ClickedOnregister(ActionEvent event) throws IOException {
        String user = userName.textProperty().getValueSafe();
        String pswd = password.textProperty().getValueSafe();
        String mail = email.textProperty().getValueSafe();
        LocalDate inputBirthday = dateOfBirth.getValue();
        if(navegacion.exitsNickName(user)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("IINFORMATION");
            alert.setHeaderText("Username existing");
            //alert.setContentText("Has comprado en " );
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
            return;
        }else if (User.checkNickName(mail)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("IINFORMATION");
            alert.setHeaderText("Wrong username");
            alert.setContentText("\"A nickname is valid if it is between 6 and 15 characters long and contains uppercase or lowercase letters or the hyphens '-' and '_' .\"" );
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
            return;
        }else if (!User.checkEmail(mail)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("IINFORMATION");
            alert.setHeaderText("Invalid Email");
            //alert.setContentText("Has comprado en " );
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
        } else if (!User.checkPassword(pswd)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("IINFORMATION");
            alert.setHeaderText("Invalid password");
            alert.setContentText("A password is valid if:\n" +
                    "- it contains between 8 and 20 characters\n" +
                    "- contains at least one upper case letter\n" +
                    "- contains at least one lower case letter\n" +
                    "- contains at least one digit\n" +
                    "- contains a special character from the set:\n" +
                    "!@#$%&*&*()-+=\n" +
                    "- does not contain any blanks" );
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
        }else {
            try {
                player = navegacion.registerUser(user, mail, pswd, inputBirthday);
            } catch (NavegacionDAOException ex) {
                Logger.getLogger(FXMLRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
            //player = isExist;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
            alert.setHeaderText("Registration worked");
            alert.setContentText("Your account has been created" );
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
            
            //
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLlogin.fxml"));
            Parent root = loader.load();
            FXMLloginController logincontroller = loader.getController();
            logincontroller.initData(navegacion,player);
            Stage stage=new Stage();
            stage.setTitle("Log In");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
            buttonLogIn.getScene().getWindow().hide();
        }
        
        
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

    @FXML
    private void fileChose(ActionEvent event) {
        FileChooser fc =new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("png files","*.png"));
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
