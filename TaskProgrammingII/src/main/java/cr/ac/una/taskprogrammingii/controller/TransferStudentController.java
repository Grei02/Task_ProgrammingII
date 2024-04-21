package cr.ac.una.taskprogrammingii.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import cr.ac.una.taskprogrammingii.model.Account;
import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.model.Transfer;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class TransferStudentController extends Controller implements Initializable {

    private FileManager fileManager= new FileManager();
    private List <Associated> associatedList;
    private Associated associated;
    private Mensaje message=new Mensaje();
    private Account accountChose=new Account();
    
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private MFXComboBox<String> cmbAccount;

    @FXML
    private MFXComboBox<String> cmbTransferType;

    @FXML
    private TextField txtAccountAmount;

    @FXML
    private TextField txtAmountTransfer;

    @FXML
    private TextField txtFolio;

    @FXML
    private TextField txtName;

    @FXML
    void onActionBtnCancel(ActionEvent event) {
        resetScreen();
    }

    @FXML
    void onActionBtnSave(ActionEvent event) {
        if(txtAmountTransfer.getText().matches("[0-9]+")){
            if(((cmbTransferType.getText().equals("Retiro"))&&(Integer.valueOf(txtAmountTransfer.getText())<=accountChose.getAmount()))||
                  cmbTransferType.getText().equals("Deposito")){
                  addTransfer();
                  fileManager.serialization(associatedList, "ListAssociated.txt");
                  resetScreen();
            }
            else{
                    message.show(Alert.AlertType.WARNING, "Aviso", "No hay suficientes fondos para realizar el retiro.");
                    txtAmountTransfer.setText(null);
            }
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "El valor ingresado no es valido.");
            txtAmountTransfer.setText(null);
        }
    }
    
    @FXML
    void onActionCmbAccount(ActionEvent event) {
        searchAccount();
        cmbTransferType.getItems().clear();
        if(accountChose.getAmount()!=null){
        txtAccountAmount.setText(accountChose.getAmount().toString());
        }
        else{
             txtAccountAmount.setText("0");
        }
        cmbTransferType.getItems().addAll("Deposito", "Retiro");
        cmbTransferType.setDisable(false);
    }

    @FXML
    void onActionCmbTransferType(ActionEvent event) {
        txtAmountTransfer.setDisable(false);
    }

    @FXML
    void onActionTxtAmountTransfer(ActionEvent event) {
        btnSave.setDisable(false);
    }

    @FXML
    void onActionTxtFolio(ActionEvent event) {
        if (searchAssociated()){
            txtFolio.setDisable(true);
            txtName.setText(associated.getName()+ " "+associated.getLastName()+" "+associated.getSecondLastName()+".");
            StartCmbAccount();
            message.show(Alert.AlertType.INFORMATION, "Confirmacion", "Se ha encontrado el asociado, ahora por favor escoger la cuenta a la que desea hacer el deposito");
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "No se ha encontrado ningun asociado, intente de nuevo.");
            txtFolio.setText(null);
        }
    }
    
    public void cleanComponents(){
        txtFolio.setText(null);
        txtName.setText(null);
        cmbAccount.getItems().clear();
        cmbTransferType.getItems().clear();
        cmbAccount.setValue(null);
        cmbTransferType.setValue(null);
        txtAccountAmount.setText(null);
        txtAmountTransfer.setText(null);
    }
    
    public void makeTransfer(){
        if(txtAmountTransfer.getText()!="0"){
            if(cmbTransferType.getText().equals("Retiro")){
                accountChose.withdrawaAmountl(Integer.valueOf(txtAmountTransfer.getText()));
            }
            else if(cmbTransferType.getText().equals("Deposito")){
                accountChose.depositAmount(Integer.valueOf(txtAmountTransfer.getText()));
            }
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "No hay ningun monto para realizar la transferencia.");
        }
    }
    
    public void addTransfer(){
        List<Transfer> listTransfer=accountChose.getListTransfer();
        if(listTransfer==null){
             listTransfer=new ArrayList<>();
         }
        listTransfer.add(new Transfer(cmbTransferType.getText(),txtAmountTransfer.getText()));
        makeTransfer();
    }
    
    public void StartCmbAccount(){
        List<Account> accountAssciatedList=associated.getAcountList();
        List <String> typeAccountList=new ArrayList<>();
        ObservableList<String>items=null;
        if(accountAssciatedList!=null){
            for(Account currentAccount:accountAssciatedList){
            typeAccountList.add(currentAccount.getType());
            }
            items=FXCollections.observableArrayList(typeAccountList);
            cmbAccount.setItems(items);
            cmbAccount.setDisable(false);
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "Este asociado no tiene cuentas.");
        }
        
    }
    
    public Boolean searchAssociated (){
           associatedList= fileManager.deserialize("ListAssociated.txt");
           String folio=txtFolio.getText().trim().toUpperCase();
            for(Associated compareAssociated:associatedList){
                if(compareAssociated.getFolio().equals(folio)){
                    associated=compareAssociated;
                    return true;
                }
            }
            return false;
      }
    
    public void searchAccount(){
        List<Account> listAccount=associated.getAcountList();
        for(Account accountCompare:listAccount){
            if(accountCompare.getType().equals(cmbAccount.getValue())){
                accountChose=accountCompare;
                break;
            }
        }
    }
    
    public void resetScreen(){
        txtFolio.setDisable(false);
        cleanComponents();
        txtName.setDisable(true);
        cmbAccount.setDisable(true);
        txtAccountAmount.setDisable(true);
        txtAmountTransfer.setDisable(true);
        btnSave.setDisable(true);
        cmbTransferType.setDisable(true);
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resetScreen();
    }    

    @Override
    public void initialize() {
        resetScreen();
    }
        

}
