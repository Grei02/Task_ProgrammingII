/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Account;
import cr.ac.una.taskprogrammingii.model.FileManager;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CreateAccountController extends Controller   implements Initializable {

    private FileManager fileManager = new FileManager<>();
   
    @FXML
    private MFXButton btnSave;

    @FXML
    private MFXTextField txtNameAccount;
    
    @FXML
    void OnActionBtnSave(ActionEvent event) {
    String newAccount = txtNameAccount.getText();
    if (!newAccount.isEmpty()) {
        fileManager.serialization(newAccount, "accounts.txt");
        System.out.println("Cuenta guardada con éxito.");
    
    } else {
        System.out.println("El nombre de la cuenta no puede estar vacío.");
        System.out.println(fileManager.deserialize("accounts.txt").get(3));
    }
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @Override
    public void initialize() {
        
    }
}
