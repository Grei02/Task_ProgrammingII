/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Account;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class CreateAccountController extends Controller   implements Initializable {

    @FXML
    private MFXButton btnSave;

    /**
     * Initializes the controller class.
     */
    private List<Account> accountList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @Override
    public void initialize() {
    }

    @FXML
    private void OnActionBtnSave(ActionEvent event) {
        
    }
    
}
