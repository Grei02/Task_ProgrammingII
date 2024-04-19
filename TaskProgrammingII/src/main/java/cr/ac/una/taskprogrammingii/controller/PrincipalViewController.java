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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
 

public class PrincipalViewController extends Controller implements Initializable {
    
      private boolean isProfessor=true;
      private boolean isAssociate=false;
      private boolean isStudent=false;

    @FXML
    private MFXButton btnRegister;
    
    @FXML
    private MFXButton btnAccountStatement;
    
    @FXML
    private MFXButton btnDeposit;
    
    @FXML
    private MFXButton btnCreateAccount;
   
    @FXML
    private MFXButton btnEdit;
    
    @FXML
    private MFXButton btnMailboxStudent;
    
    @FXML
    private MFXButton btnAccountMant;
    
    @FXML
    private BorderPane root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setButtonVisibility();
    }    

    @Override
    public void initialize() {
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
        FlowController.getInstance().goView("DepositAssociatedView");
    }

    @FXML
    private void OnActionBtnCreateAccount(ActionEvent event) {
         FlowController.getInstance().goView("createAccountView");
    }    
    
     @FXML
    private void onActionBtnEdit(ActionEvent event) {
         FlowController.getInstance().goView("editWindowView");
    }
    
    @FXML
    void OnActionBtnMailboxStudent(ActionEvent event) {
         FlowController.getInstance().goView("mailboxStudentView");
    }

    private void setButtonVisibility() {
        if (isProfessor) {
            btnRegister.setVisible(false);
            btnAccountStatement.setVisible(false);
            btnDeposit.setVisible(false);
            btnCreateAccount.setVisible(true);
           
        } else if ( isAssociate) {
            btnRegister.setVisible(true);
            btnAccountStatement.setVisible(true);
            btnDeposit.setVisible(true);
            btnCreateAccount.setVisible(false);
            btnEdit.setVisible(false);
        }
        else if(isStudent){
            btnRegister.setVisible(true);
            btnAccountStatement.setVisible(false);
            btnDeposit.setVisible(true);
            btnCreateAccount.setVisible(false);
            btnEdit.setVisible(false);
            btnMailboxStudent.setVisible(true);
        }
    }    

    @FXML
    private void OnActionBtnAccountMant(ActionEvent event) {
        FlowController.getInstance().goView("AccountMaintenanceView");
    }
}
