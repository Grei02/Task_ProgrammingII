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
import javafx.scene.control.Alert;

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
        List<String> existingAccounts = fileManager.deserialize("accounts.txt");
        if (!existingAccounts.contains(newAccount)) {
            fileManager.serialization(newAccount, "accounts.txt");
           Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setContentText("Cuenta guardada con éxito.");
            successAlert.setHeaderText(null);
            successAlert.showAndWait();
            txtNameAccount.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("La cuenta ya está registrada.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    } else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("El nombre de la cuenta no puede estar vacío.");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @Override
    public void initialize() {
        
    }
}
