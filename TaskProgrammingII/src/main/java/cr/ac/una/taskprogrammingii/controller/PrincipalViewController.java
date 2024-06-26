/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.util.AppContext;
import cr.ac.una.taskprogrammingii.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
 

public class PrincipalViewController extends Controller implements Initializable {
    
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
    
    @FXML
    private MFXButton btnEditUser;
    
     @FXML
    private MFXButton btnConsultDeleteAssociated;
    @FXML
    private ImageView imgCoop;
    @FXML
    private Label txtCoopName;
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setButtonVisibility();
        // updateCoopName();
//       updateCoopLogo();
//        setButtonVisibility();
    }    

    @Override
    public void initialize() {
    }

//    public void updateCoopName(String newName) {
//        txtCoopName.setText(newName);
//    }
//
//    public void updateCoopLogo() {
//        Image image = new Image("src/main/resources/cr/ac/una/taskprogrammingii/resources/50colones");
//       imgCoop.setImage(image);
//    }

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
     @FXML
    void onActionBtnEditUser(ActionEvent event) {
         FlowController.getInstance().goView("editUserView");
    }
    
    @FXML
    void onActionBtnConsultDeleteAssociated(ActionEvent event) {
        FlowController.getInstance().goView("consultDeleteUserView");
    }

    private void setButtonVisibility() {
        String args=(String) AppContext.getInstance().get("typeIncome");
        switch (args) {
            case "P" -> {
                buttonEnabledTeacher();
                buttonDisabledTeacher();
            }
            case "A" -> {
                buttonEnabledAssociate();
                buttonDisabledAssociate();
            }
            case "S" -> {
                buttonEnabledStudent();
                buttonDisabledStudent();
            }
            case "L"->{
                btnEdit.setVisible(true);
                btnCreateAccount.setVisible(true);
                btnAccountInquiry.setVisible(true);
                btnAccountMant.setVisible(true);
                btnRegister.setVisible(true);
                btnDeposit.setVisible(true);
                btnAccountsOpening.setVisible(true);
                btnMailboxStudent.setVisible(true);
                btnTransfers.setVisible(true);
                btnEditUser.setVisible(true);
                
                btnEdit.setManaged(true);
                btnCreateAccount.setManaged(true);
                btnAccountInquiry.setManaged(true);
                btnAccountMant.setManaged(true);
                btnRegister.setManaged(true);
                btnDeposit.setManaged(true);
                btnAccountsOpening.setManaged(true);
                btnMailboxStudent.setManaged(true);
                btnTransfers.setManaged(true);
                btnEditUser.setManaged(true);
            
                btnEdit.setDisable(false);
                btnCreateAccount.setDisable(false);
                btnAccountInquiry.setDisable(false);
                btnAccountMant.setDisable(false);
                btnRegister.setDisable(false);
                btnDeposit.setDisable(false);
                btnAccountsOpening.setDisable(false);
                btnMailboxStudent.setDisable(false);
                btnTransfers.setDisable(false);
                btnEditUser.setDisable(false);
            }
            default -> {
            }
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
            btnEditUser.setVisible(false);
            btnConsultDeleteAssociated.setVisible(false);
            
            btnRegister.setManaged(false);
            btnDeposit.setManaged(false);
            btnAccountsOpening.setManaged(false);
            btnMailboxStudent.setManaged(false);
            btnTransfers.setManaged(false);
            btnEditUser.setManaged(false);
            btnConsultDeleteAssociated.setManaged(false);
            
            btnRegister.setDisable(true);
            btnDeposit.setDisable(true);
            btnAccountsOpening.setDisable(true);
            btnMailboxStudent.setDisable(true);
            btnTransfers.setDisable(true);
            btnEditUser.setDisable(true);
            btnEditUser.setDisable(true);
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
            btnEditUser.setVisible(false);
            btnConsultDeleteAssociated.setVisible(false);
            
            btnEdit.setManaged(false);
            btnCreateAccount.setManaged(false);
            btnAccountMant.setManaged(false);
            btnAccountsOpening.setManaged(false);
            btnMailboxStudent.setManaged(false);
            btnTransfers.setManaged(false);
            btnEditUser.setManaged(false);
            btnConsultDeleteAssociated.setManaged(false);
            
            btnEdit.setDisable(true);
            btnCreateAccount.setDisable(true);
            btnAccountMant.setDisable(true);
            btnAccountsOpening.setDisable(true);
            btnMailboxStudent.setDisable(true);
            btnTransfers.setDisable(true);
            btnEditUser.setDisable(true);
            btnEditUser.setDisable(true);
    }
    
    public void buttonEnabledStudent(){
            btnMailboxStudent.setVisible(true);
            btnTransfers.setVisible(true);
            btnAccountsOpening.setVisible(true);
            btnEditUser.setVisible(true);
            btnConsultDeleteAssociated.setVisible(true);
            
            btnMailboxStudent.setManaged(true);
            btnTransfers.setManaged(true);
            btnAccountsOpening.setManaged(true);
            btnEditUser.setManaged(true);
            btnConsultDeleteAssociated.setManaged(true);
            
            btnMailboxStudent.setDisable(false);
            btnTransfers.setDisable(false);
            btnAccountsOpening.setDisable(false);
            btnEditUser.setDisable(false);
            btnConsultDeleteAssociated.setDisable(false);
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
