/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Account;
import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.Deposits;
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
import javafx.scene.control.TextField;


public class AccountInquiryController extends Controller implements Initializable {
    
    private Mensaje message=new Mensaje();
    private FileManager fileManager= new FileManager();
    private Account accountChose=new Account();
    private List<Associated> listAssociated= new ArrayList<>();
    private List<Transfer> listTransfer= new ArrayList<>();
    private Associated associated;
    
    @FXML
    private MFXComboBox<String> cmbAccounts;
    
    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtFolio;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTotalAmount;
    
    @FXML
    void onActionCmbAccounts(ActionEvent event) {
        searchChosenAccount();
        txtTotalAmount.setText(accountChose.getAmount().toString());
    }


    @FXML
    void onActionTxtFolio(ActionEvent event) {
        if(searchAssociated()){
            loadDataAssociated();
            cmbAccounts.setDisable(false);
            startComboBox();
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "No se ha encontrado ningun asociado, intente de nuevo.");
            txtFolio.setText(null);
        }
    }
    
   public void searchChosenAccount(){
       List<Account> listAccount= associated.getAcountList();
        if(listAccount!=null){
            for(Account currentAccount:listAccount){
                  if(currentAccount.getType().equals(cmbAccounts.getValue())){
                      accountChose=currentAccount;
                      break;
                  }
            }
        }
   }
    
    public void startComboBox(){
        List<Account> listAccount= associated.getAcountList();
        List <String> typeAccountList=new ArrayList<>();
        ObservableList<String>items=null;
        if(listAccount!=null){
            for(Account currentAccount:listAccount){
            typeAccountList.add(currentAccount.getType());
            }
            items=FXCollections.observableArrayList(typeAccountList);
            cmbAccounts.setItems(items);
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "Este asociado no tiene cuentas.");
        }
    }

    public void loadDataAssociated(){
        txtAge.setText(associated.getAge());
        txtName.setText(associated.getName());
        txtLastName.setText(associated.getLastName()+" "+associated.getSecondLastName());
    }
    
    public Boolean searchAssociated(){
        String folio=txtFolio.getText().trim().toUpperCase();
        List <Associated> associatedList= fileManager.deserialize("ListAssociated.txt");
        for(Associated compareAssociated:associatedList){
            if(compareAssociated.getFolio().equals(folio)){
                associated=compareAssociated;
                return true;
            }
        }
        return false;
    }
    
    public void disableComponent(){
        cmbAccounts.setDisable(true);
        txtAge.setDisable(true);
        txtName.setDisable(true);
        txtLastName.setDisable(true);
        txtTotalAmount.setDisable(true);
    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        disableComponent();
    }    

    @Override
    public void initialize() {
       
    }
    
}
