/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import controller.FXMLMenuPrincipall;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author eliotvg
 */
public class Utils {


    
    public static void changeScene(ActionEvent event, String fxmlFile, String title) throws IOException{
        FXMLLoader loader = new FXMLLoader(Utils.class.getResource(fxmlFile));
        Parent root = loader.load();
        //AddController addController = loader.getController();

        //addController.addPerson(observableGuestList);
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
        //event.getScene().getWindow().hide();
    }
    
}
    

