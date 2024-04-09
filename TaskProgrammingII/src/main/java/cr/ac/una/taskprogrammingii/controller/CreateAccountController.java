/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Account;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    private List<String> typeAccount;
    @FXML
    private MFXTextField txtNameAccount;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @Override
    public void initialize() {
        
    }

    @FXML
    private void OnActionBtnSave(ActionEvent event) {
        //guardarCuenta();
    }
    
//    private void guardarCuenta() {
//         String newAccount = txtNameAccount.getText();
//        if (!newAccount.isEmpty()) {
//            String nuevaCuenta = new String(newAccount);
//            
//            // Si 'typeAccount' aún no se ha inicializado, inicialízalo
//            if (typeAccount == null) {
//                typeAccount = new ArrayList<>();
//            }
//           
//            typeAccount.add(nuevaCuenta);
//            
//            // Luego puedes realizar las operaciones adicionales que necesites con la lista de cuentas
//            // Por ejemplo, imprimir la lista de cuentas en la consola
//            System.out.println("Lista de cuentas:");
//            for (Account cuenta : typeAccount) {
//                System.out.println(cuenta.getNombre());
//            }
//        } else {
//            System.out.println("El nombre de la cuenta no puede estar vacío.");
//        }
//    
 
}
