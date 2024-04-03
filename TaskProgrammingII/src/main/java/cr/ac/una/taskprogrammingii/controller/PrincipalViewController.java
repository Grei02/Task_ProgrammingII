/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class PrincipalViewController extends Controller implements Initializable {

    @FXML
    private MFXButton btnRegister;
    @FXML
    private MFXButton btnAccountStatement;
    @FXML
    private MFXButton btnDeposit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void onActionBtnRegister(ActionEvent event) {
         FlowController.getInstance().goView("registerAssociateSectionView");
    }

    @FXML
    private void onActionBtnAccountStatement(ActionEvent event) {
        FlowController.getInstance().goView("accountStatementConsultationView");
    }

    @FXML
    private void onActionBtnDeposit(ActionEvent event) {
        FlowController.getInstance().goView("DepositInAccountView");
    }
    
}
