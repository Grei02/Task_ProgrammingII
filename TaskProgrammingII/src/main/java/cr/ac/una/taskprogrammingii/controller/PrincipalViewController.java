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
    
      private boolean isProfessor=false;
      private boolean isAssociate=false;
      private boolean isStudent=true;

    @FXML
    private MFXButton btnRegister;
    
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
    
    @FXML
    private MFXButton btnAccountInquiry;
    
    @FXML
    private MFXButton btnTransfers;
    
    @FXML
    private MFXButton btnAccountsOpening;
    
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
    void OnActionBtnAccountInquiry(ActionEvent event) {
        FlowController.getInstance().goView("accountInquiryView");
    }
    
    @FXML
    private void onActionBtnRegister(ActionEvent event) {
         FlowController.getInstance().goView("registerAssociateSectionView");
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
    
    @FXML
    void onActionBtnTransfers(ActionEvent event) {
        FlowController.getInstance().goView("transferStudentView");
    }
    
    @FXML
    void onActionBtnAccountsOpening(ActionEvent event) {
        FlowController.getInstance().goView("AddDavilitarAccountsView");
    }
    
    @FXML
    private void OnActionBtnAccountMant(ActionEvent event) {
        FlowController.getInstance().goView("AccountMaintenanceView");
    }

    private void setButtonVisibility() {
        if (isProfessor) {
            buttonEnabledTeacher();
            buttonDisabledTeacher();
            
        } 
        else if ( isAssociate) {
            buttonEnabledAssociate();
            buttonEnabledAssociate();

        }
        else if(isStudent){
            buttonEnabledStudent();
            buttonDisabledStudent();
        }
    }    
    
    public void buttonEnabledTeacher(){
            btnEdit.setVisible(true);
            btnCreateAccount.setVisible(true);
            btnAccountInquiry.setVisible(true);
            btnAccountMant.setVisible(true);
            
            btnEdit.setManaged(true);
            btnCreateAccount.setManaged(true);
            btnAccountInquiry.setManaged(true);
            btnAccountMant.setManaged(true);
            
            btnEdit.setDisable(false);
            btnCreateAccount.setDisable(false);
            btnAccountInquiry.setDisable(false);
            btnAccountMant.setDisable(false);
    }
    
    public void buttonDisabledTeacher(){
            btnRegister.setVisible(false);
            btnDeposit.setVisible(false);
            btnAccountsOpening.setVisible(false);
            btnMailboxStudent.setVisible(false);
            btnTransfers.setVisible(false);
            
            btnRegister.setManaged(false);
            btnDeposit.setManaged(false);
            btnAccountsOpening.setManaged(false);
            btnMailboxStudent.setManaged(false);
            btnTransfers.setManaged(false);
            
            btnRegister.setDisable(true);
            btnDeposit.setDisable(true);
            btnAccountsOpening.setDisable(true);
            btnMailboxStudent.setDisable(true);
            btnTransfers.setDisable(true);
    }
    
    public void buttonEnabledAssociate(){
            btnAccountInquiry.setVisible(true);
            btnRegister.setVisible(true);
            btnDeposit.setVisible(true);
            
            btnAccountInquiry.setManaged(true);
            btnRegister.setManaged(true);
            btnDeposit.setManaged(true);
            
            btnAccountInquiry.setDisable(false);
            btnRegister.setDisable(false);
            btnDeposit.setDisable(false);
    }
    
    public void buttonDisabledAssociate(){
            btnEdit.setVisible(false);
            btnCreateAccount.setVisible(false);
            btnAccountMant.setVisible(false);
            btnAccountsOpening.setVisible(false);
            btnMailboxStudent.setVisible(false);
            btnTransfers.setVisible(false);
            
            btnEdit.setManaged(false);
            btnCreateAccount.setManaged(false);
            btnAccountMant.setManaged(false);
            btnAccountsOpening.setManaged(false);
            btnMailboxStudent.setManaged(false);
            btnTransfers.setManaged(false);
            
            btnEdit.setDisable(true);
            btnCreateAccount.setDisable(true);
            btnAccountMant.setDisable(true);
            btnAccountsOpening.setDisable(true);
            btnMailboxStudent.setDisable(true);
            btnTransfers.setDisable(true);
    }
    
    public void buttonEnabledStudent(){
            btnMailboxStudent.setVisible(true);
            btnTransfers.setVisible(true);
            btnAccountsOpening.setVisible(true);
            
            btnMailboxStudent.setManaged(true);
            btnTransfers.setManaged(true);
            btnAccountsOpening.setManaged(true);
            
            btnMailboxStudent.setDisable(false);
            btnTransfers.setDisable(false);
            btnAccountsOpening.setDisable(false);
    }

    public void buttonDisabledStudent(){
            btnAccountInquiry.setVisible(false);
            btnRegister.setVisible(false);
            btnDeposit.setVisible(false);
            btnEdit.setVisible(false);
            btnCreateAccount.setVisible(false);
            btnAccountMant.setVisible(false);
            
            btnAccountInquiry.setManaged(false);
            btnRegister.setManaged(false);
            btnDeposit.setManaged(false);
            btnEdit.setManaged(false);
            btnCreateAccount.setManaged(false);
            btnAccountMant.setManaged(false);
            
            btnAccountInquiry.setDisable(true);
            btnRegister.setDisable(true);
            btnDeposit.setDisable(true);
            btnEdit.setDisable(true);
            btnCreateAccount.setDisable(true);
            btnAccountMant.setDisable(true);
    }

}
