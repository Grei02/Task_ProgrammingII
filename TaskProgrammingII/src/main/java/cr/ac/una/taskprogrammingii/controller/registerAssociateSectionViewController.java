/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.associated;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class registerAssociateSectionViewController implements Initializable {
    
     private associated associated=new associated();
    
    @FXML
    private TextField txtUserAge;

    @FXML
    private TextField txtUserLastName;

    @FXML
    private TextField txtuserName;
    
    @FXML
    private Button btnReady;
    
    @FXML
    void onActionBtnReady(ActionEvent event) {
        
        if((((associated.getAge()==null) || associated.getAge().isBlank()) )||
                ((associated.getLastName()==null)||(associated.getLastName().isBlank()))||
                ((associated.getName()==null)||(associated.getName().isBlank()))){
            
        }
        else{
             ((Stage)btnReady.getScene().getWindow()).close();
        }
    }
    
    @FXML
    void onActionTxtUserAge(ActionEvent event) {
        associated.setAge(txtUserAge.getText());
    }

    @FXML
    void onActionTxtUserLastName(ActionEvent event) {
        associated.setLastName(txtUserLastName.getText());
       
    }

    @FXML
    void onActionTxtuserName(ActionEvent event){
        if(!txtuserName.getText().isBlank()){
         associated.setName(txtuserName.getText());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
