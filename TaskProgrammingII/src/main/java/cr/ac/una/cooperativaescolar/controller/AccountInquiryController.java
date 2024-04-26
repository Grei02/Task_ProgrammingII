/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.cooperativaescolar.controller;

import cr.ac.una.cooperativaescolar.model.Account;
import cr.ac.una.cooperativaescolar.model.Associated;
import cr.ac.una.cooperativaescolar.model.FileManager;
import cr.ac.una.cooperativaescolar.model.Transfer;
import cr.ac.una.cooperativaescolar.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class AccountInquiryController extends Controller implements Initializable {
    
    private Mensaje message=new Mensaje();
    private FileManager fileManager= new FileManager();
    private Account accountChose=new Account();
    private Associated associated;
    
    @FXML
    private AnchorPane root;

    @FXML
    private Button btnDetailed;

    @FXML
    private Button btnSummarized;
    
    @FXML
    private Button btnReady;
    
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
    private MFXLegacyTableView<Transfer> ltvTransferTable;
    
    @FXML
    private TableColumn<Transfer, String> tbcAmount;

    @FXML
    private TableColumn<Transfer, String> tbcTransferType;
    
    @FXML
    private VBox vbxTable;

    @FXML
    void onActionBtnReady(ActionEvent event) {
        resetScreen();
    }
    
    @FXML
    void onActionCmbAccounts(ActionEvent event) {
        searchChosenAccount();
        txtTotalAmount.setText(accountChose.getAmount().toString());
        initializeTable();
        btnDetailed.setDisable(false);
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
    
    @FXML
    void onActionBtnDetailed(ActionEvent event) {
        enableSummaryButton(true);
    }

    @FXML
    void onActionBtnSummarized(ActionEvent event) {
       enableSummaryButton(false); 
    }
    
   public void enableSummaryButton(Boolean enableSummary) {
        btnSummarized.setVisible(enableSummary);
        btnSummarized.setManaged(enableSummary);
        btnDetailed.setVisible(!enableSummary);
        btnDetailed.setManaged(!enableSummary);
        vbxTable.setVisible(enableSummary);
        vbxTable.setManaged(enableSummary);
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
    
    public void initializeTable(){
        if(accountChose.getListTransfer()!=null){
            List<String> listTypeTransfer=new ArrayList<>();
            ObservableList<Transfer> itemsTransfer=null;
            itemsTransfer=FXCollections.observableArrayList(accountChose.getListTransfer());
            
            tbcTransferType.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getType()));
            tbcAmount.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAmount()));
            ltvTransferTable.setItems(itemsTransfer);
        }
    }
    
    public void resetScreen(){
        btnSummarized.setDisable(false);
        cmbAccounts.setDisable(true);
        txtAge.setDisable(true);
        txtName.setDisable(true);
        txtLastName.setDisable(true);
        txtTotalAmount.setDisable(true);
        enableSummaryButton(false);
        cleanComponents();
    }
    
    public void cleanComponents(){
        ltvTransferTable.getItems().clear();
        cmbAccounts.getItems().clear();
        cmbAccounts.setValue(null);
        cmbAccounts.getSelectionModel().clearSelection();
        txtFolio.setText(null);
        txtAge.setText(null);
        txtLastName.setText(null);
        txtName.setText(null);
        txtTotalAmount.setText(null);
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
