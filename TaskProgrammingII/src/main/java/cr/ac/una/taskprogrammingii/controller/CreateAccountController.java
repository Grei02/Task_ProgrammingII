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

    @FXML
    private MFXButton btnSave;

    private FileManager<List<String>> fileManager = new FileManager<>();
    @FXML
    private MFXTextField txtNameAccount;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<List<String>> accounts = fileManager.deserialize("accountTypeList.txt");
    }    
    @Override
    public void initialize() {
    }
    
//  private void OnActionBtnSave(ActionEvent event) {
//    String newAccount = txtNameAccount.getText();
//    if (!newAccount.isEmpty()) {
//        List<String> accounts = fileManager.deserialize();
//        accounts.add(newAccount);
//        fileManager.serialization(accounts, "accounts.txt");
//        System.out.println("Cuenta guardada con éxito.");
//    } else {
//        System.out.println("El nombre de la cuenta no puede estar vacío.");
//    }
//}
}
