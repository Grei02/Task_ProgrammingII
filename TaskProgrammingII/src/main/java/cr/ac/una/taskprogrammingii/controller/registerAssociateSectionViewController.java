/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


public class registerAssociateSectionViewController implements Initializable {

    private String name;
    private String lastName;
    private String age;
    
    @FXML
    private TextField txtUserAge;

    @FXML
    private TextField txtUserLastName;

    @FXML
    private TextField txtuserName;
    
    @FXML
    void onActionTxtUserAge(ActionEvent event) {
        age=txtUserAge.getText();
        System.out.println("Texto ingresado: " + age);
    }

    @FXML
    void onActionTxtUserLastName(ActionEvent event) {
        lastName=txtUserLastName.getText();
    }

    @FXML
    void onActionTxtuserName(ActionEvent event) {
        name=txtUserLastName.getText();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
