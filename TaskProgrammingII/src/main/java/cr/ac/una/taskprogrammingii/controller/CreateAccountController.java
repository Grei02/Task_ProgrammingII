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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import cr.ac.una.taskprogrammingii.util.Mensaje;


public class CreateAccountController extends Controller   implements Initializable {
    Mensaje message= new Mensaje();
    private FileManager fileManager = new FileManager<>();
    List<String> listDeserialization= new ArrayList<>();
   
    @FXML
    private MFXButton btnSave;

    @FXML
    private MFXTextField txtNameAccount;
    
    @FXML
    void OnActionBtnSave(ActionEvent event) {
    String newAccount = txtNameAccount.getText();
    if (!newAccount.isEmpty()) {
        List<String> existingAccounts = fileManager.deserialize("accounts.txt");
        for(String accountTypeCompare:existingAccounts) {
            if(!(accountTypeCompare.trim().toUpperCase().equals(accountTypeCompare.trim().toUpperCase()))){
                listDeserialization=fileManager.deserialize("accounts.txt");
                listDeserialization.add(newAccount);
                fileManager.serialization(listDeserialization, "accounts.txt");
                message.show(Alert.AlertType.INFORMATION, "Confirmacion", "Cuenta guardada con éxito.");
                break;
            }
            else {
             message.show(Alert.AlertType.ERROR, "Error", "La cuenta ya está registrada..");
             break;
        } 

        }
    } else {
         message.show(Alert.AlertType.ERROR, "Error", "El nombre de la cuenta no puede estar vacío.");
    }
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @Override
    public void initialize() {
        
    }
}
