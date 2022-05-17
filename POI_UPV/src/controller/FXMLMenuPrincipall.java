/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Navegacion;
import model.Session;
import model.User;
import controller.FXMLloginController;
import java.io.IOException;

/**
 * FXML Controller class
 *
 * @author eliotvg
 */
public class FXMLMenuPrincipall implements Initializable {

    @FXML
    private ImageView avatar;
    @FXML
    private Label userName;
    @FXML
    private Label userEmail;
    @FXML
    private Label averageGrade;
    @FXML
    private Label nbExPassed;
    @FXML
    private Label nbExFailed;
    @FXML
    private Button butttonExercice;
    
    private Navegacion navegacion;
    
    private User player;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void initData(Navegacion nav, User plyr){
        navegacion = nav;
        player = plyr;
        List<Session> listSessions = plyr.getSessions();
        Integer nbPassed = 0;
        Integer nbFailed=0;
        Integer nbEx =0;
        Integer i =0;
        Session sess = null;
        for (i=0;i<listSessions.size();i++){
            sess = listSessions.get(i);
            nbPassed += sess.getHits();
            nbFailed += sess.getFaults();
            nbEx += sess.getFaults() + sess.getFaults();
        }
        Double avgG=0.0;
        if (nbEx!=0){
            avgG = Double.valueOf(nbPassed/nbEx)*100;
        }
        
        
        setUpUserInformation(player.getNickName(), player.getEmail(),avgG,nbPassed,nbFailed);      
    }
    
    public void setUpUserInformation(String username, String email, Double avgGrade, Integer nbPassed,Integer nbFailed  ){
        userName.setText(username);
        userEmail.setText(email);
        String s=String.valueOf(avgGrade);  
        String s1=String.valueOf(nbPassed);  
        String s2=String.valueOf(nbFailed);  
        averageGrade.setText(s);
        nbExPassed.setText(s1);
        nbExFailed.setText(s2);                  
    }

    @FXML
    private void OnClickedEditProfile(ActionEvent event) {
        
    }

    @FXML
    private void OnClickedSetting(ActionEvent event) {
    }

    @FXML
    private void OnClickedLogOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLlogin.fxml"));
        Parent root = loader.load();
        //FXMLloginController addController = loader.getController();

        //addController.initData(navegacion,player);
        Stage stage=new Stage();
        stage.setTitle("Log In");
        //stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
        butttonExercice.getScene().getWindow().hide();
    }

    @FXML
    private void OnClickedExercice(ActionEvent event) {
    }

    @FXML
    private void OnClickedRanking(ActionEvent event) {
    }
    
}
