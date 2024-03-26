/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

import java.awt.event.MouseEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sofia Bejarano Mora
 */
public class associatedRegistrationController implements Initializable {
    Boolean activatedEnterFolio= true;
    
 @FXML
    private Button btnIncome;

    @FXML
    private Button btnIncomeChange;

    @FXML
    private PasswordField pstFolio;

    @FXML
    private AnchorPane root;

      @FXML
    private Label labIncome;

    @FXML
    private Label labIncomeChange;

    @FXML
    void onActionBtnIncome(ActionEvent event) {

    }

    @FXML
    void onActionBtnIncomeChange(ActionEvent event) {
        activatedEnterFolio=!activatedEnterFolio;
       if(activatedEnterFolio){
           activatedEnterFolio=false;
            labIncomeChange.setText("Ocupamos que nos des una pequeña ayuda, nos podrias dar tu nombre completo?");
        }
       else if (!activatedEnterFolio){
           activatedEnterFolio=true;
            labIncome.setText("Ocupamos que nos des una pequeña ayuda, nos podrias dar tu nombre completo.");
            labIncomeChange.setText("¿Prefieres ingresar tu folio?");
        }
    }

    @FXML
    void onActionPstFolio(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
