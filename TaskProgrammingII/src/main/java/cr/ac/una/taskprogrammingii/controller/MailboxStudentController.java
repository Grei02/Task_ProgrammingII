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
import io.github.palexdev.materialfx.controls.MFXSpinner;
import io.github.palexdev.materialfx.controls.models.spinner.IntegerSpinnerModel;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class MailboxStudentController extends Controller implements Initializable {
    
    private Associated associated=new Associated();
    private Deposits deposit=new Deposits();
    private FileManager fileManager= new FileManager();
    private List<Deposits> listDeposit= new ArrayList<>();
    private List<Deposits> listDeserialization= new ArrayList<>();
    private Mensaje message=new Mensaje();
    private List<Associated> associatedList=new ArrayList<>();
    
   @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;
    
    @FXML
    private MFXComboBox<String> cmbDepositNumber;

    @FXML
    private AnchorPane root;

    @FXML
    private MFXSpinner<Integer> spn10000Bills;

    @FXML
    private MFXSpinner<Integer> spn1000Bills;

    @FXML
    private MFXSpinner<Integer> spn100Coins;

    @FXML
    private MFXSpinner<Integer> spn10Coins;

    @FXML
    private MFXSpinner<Integer> spn20000Bills;

    @FXML
    private MFXSpinner<Integer> spn2000Bills;

    @FXML
    private MFXSpinner<Integer> spn25Coins;

    @FXML
    private MFXSpinner<Integer> spn5000Bills;

    @FXML
    private MFXSpinner<Integer> spn500Coins;

    @FXML
    private MFXSpinner<Integer> spn50Coins;

    @FXML
    private MFXSpinner<Integer> spn5Coins;

    @FXML
    private TextField txtFolioUser;

    @FXML
    private TextField txtTotalAmount;

    @FXML
    private TextField txtTypeAccount;
    
    @FXML
    private TextField txtUserName;

    @FXML
    void onMouseClickedSpn10000Bills(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }

    @FXML
    void onMouseClickedSpn1000Bills(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }

    @FXML
    void onMouseClickedSpn100Coins(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }

    @FXML
    void onMouseClickedSpn10Coins(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }

    @FXML
    void onMouseClickedSpn20000Bills(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }

    @FXML
    void onMouseClickedSpn2000Bills(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }

    @FXML
    void onMouseClickedSpn25Coins(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }

    @FXML
    void onMouseClickedSpn5000Bills(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }

    @FXML
    void onMouseClickedSpn500Coins(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }

    @FXML
    void onMouseClickedSpn50Coins(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }

    @FXML
    void onMouseClickedSpn5Coins(MouseEvent event) {
         setAmounts();
         deposit.calculateTotal();
         txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }
    
    
    @FXML
    void onActionBtnCancel(ActionEvent event) {
        resetScreen();
    }

    @FXML
    void onActionbtnSave(ActionEvent event) {
        setAmounts();
        deposit.calculateTotal();
        if(deposit.getTotal()!=0){
            associatedList=fileManager.deserialize("ListAssociated.txt");
            listDeserialization=fileManager.deserialize("DepositList.txt");
            addTransfer();
            fileManager.serialization(associatedList, "ListAssociated.txt");
            associatedList=fileManager.deserialize("ListAssociated.txt");
            listDeserialization.remove(Integer.parseInt(cmbDepositNumber.getValue())-1);
            fileManager.serialization(listDeserialization, "DepositList.txt");
            resetScreen();
             
        }
        else if (deposit.getTotal()==0){
            listDeserialization=fileManager.deserialize("DepositList.txt");
            listDeserialization.remove(Integer.parseInt(cmbDepositNumber.getValue())-1);
            fileManager.serialization(listDeserialization, "DepositList.txt");
            resetScreen();
        }
    }

    @FXML
    void onActiontxtFolioUser(ActionEvent event) {
        if(searchDeposit()){
            txtFolioUser.setDisable(true);
            cmbDepositNumber.setDisable(false);
            StartCmbAccountTypes();
            deposit.setFolio(txtFolioUser.getText().trim().toUpperCase());
            searchAssociated();
        }
        else if(!searchDeposit()){
            message.show(Alert.AlertType.WARNING, "Aviso", "Este folio no tiene ningun deposito.");
            txtFolioUser.setText(null);
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "Este folio no coincide con ningun asociado.");
            txtFolioUser.setText(null);
        }
    }
    
    @FXML
    void onActionCmbDepositNumber(ActionEvent event) {
        if(cmbDepositNumber.getValue()!=null){
        int depositNumber=Integer.parseInt(cmbDepositNumber.getValue());
        deposit=listDeposit.get(depositNumber-1);
         txtUserName.setText(associated.getName()+associated.getLastName()+
         associated.getSecondLastName());
         txtTypeAccount.setText(deposit.getTypeAccount());
         loadDepositValues();
         disableSpinner(false);
         btnSave.setDisable(false);
        }
    }
    
    public void addTransfer(){
        List<Account> accountList=associated.getAcountList();
            for(Account compareAccountList:accountList){
                if(compareAccountList.getType().equals(deposit.getTypeAccount())){
                     List<Transfer> listTransfer=compareAccountList.getListTransfer();
                     if(listTransfer==null){
                         listTransfer=new ArrayList<>();
                         compareAccountList.setListTransfer(listTransfer);
                     }
                    listTransfer.add(new Transfer("Deposito", Integer.toString(deposit.getTotal())));
                    break;
                }
            }
    }
    
    public void searchAssociated(){
         List <Associated> associatedList= fileManager.deserialize("ListAssociated.txt");
        for(Associated compareAssociated:associatedList){
            if(compareAssociated.getFolio().equals(deposit.getFolio())){
                associated=compareAssociated;
                break;
            }
        }
    }
    
    public void setAmounts(){
       deposit.setCoin5(spn5Coins.getValue());
       deposit.setCoin10(spn10Coins.getValue());
       deposit.setCoin25(spn25Coins.getValue());
       deposit.setCoin50(spn50Coins.getValue());
       deposit.setCoin100(spn100Coins.getValue());
       deposit.setCoin500(spn500Coins.getValue());
       deposit.setBill1000(spn1000Bills.getValue());
       deposit.setBill2000(spn2000Bills.getValue());
       deposit.setBill5000(spn5000Bills.getValue());
       deposit.setBill10000(spn10000Bills.getValue());
       deposit.setBill20000(spn20000Bills.getValue());
   }
    
    public void loadDepositValues(){
        spn10000Bills.setValue(deposit.getBill10000());
        spn1000Bills.setValue(deposit.getBill1000());
        spn100Coins.setValue(deposit.getCoin100());
        spn10Coins.setValue(deposit.getCoin10());
        spn20000Bills.setValue(deposit.getBill20000());
        spn2000Bills.setValue(deposit.getBill2000());
        spn25Coins.setValue(deposit.getCoin25());
        spn5000Bills.setValue(deposit.getBill5000());
        spn500Coins.setValue(deposit.getCoin500());
        spn50Coins.setValue(deposit.getCoin50());
        spn5Coins.setValue(deposit.getCoin5());
        txtTotalAmount.setText(Integer.toString(deposit.getTotal()));
    }
    
    public Boolean searchDeposit(){
        listDeposit.clear();
        Boolean isDeposit= false;
        listDeserialization=fileManager.deserialize("DepositList.txt");
        String folio=txtFolioUser.getText().trim();
        folio=folio.toUpperCase();
        for(Deposits comparisonDeposit:listDeserialization){
            if(comparisonDeposit.getFolio().equals(folio)){
                listDeposit.add(comparisonDeposit);
                isDeposit= true;
            }
        }
        return isDeposit;
    }
    
    public void resetScreen(){
       initializeSpinner();
       txtFolioUser.setDisable(false);
       txtFolioUser.setText(null);
       txtTotalAmount.setText("0");
       txtUserName.setText(null);
       txtTypeAccount.setText(null);
        txtTotalAmount.setDisable(true);
        txtTypeAccount.setDisable(true);
        btnSave.setDisable(true);
        txtUserName.setDisable(true);
        cmbDepositNumber.setDisable(true);
        cmbDepositNumber.setValue(null);
        cmbDepositNumber.getSelectionModel().clearSelection();
         disableSpinner(true);
    }
    
    public void disableSpinner(Boolean enable){
    spn10000Bills.setDisable(enable);
    spn1000Bills.setDisable(enable);
    spn100Coins.setDisable(enable);
    spn10Coins.setDisable(enable);
    spn20000Bills.setDisable(enable);
    spn2000Bills.setDisable(enable);
    spn25Coins.setDisable(enable);
    spn5000Bills.setDisable(enable);
    spn500Coins.setDisable(enable);
    spn50Coins.setDisable(enable);
    spn5Coins.setDisable(enable);
}
    
    public void initializeSpinner(){
        spn10000Bills.setSpinnerModel (new IntegerSpinnerModel (0));
        spn1000Bills.setSpinnerModel (new IntegerSpinnerModel (0));
        spn100Coins.setSpinnerModel (new IntegerSpinnerModel (0));
        spn10Coins.setSpinnerModel (new IntegerSpinnerModel (0));
        spn20000Bills.setSpinnerModel (new IntegerSpinnerModel (0));
        spn2000Bills.setSpinnerModel (new IntegerSpinnerModel (0));
        spn25Coins.setSpinnerModel (new IntegerSpinnerModel (0));
        spn5000Bills.setSpinnerModel (new IntegerSpinnerModel (0));
        spn500Coins.setSpinnerModel (new IntegerSpinnerModel (0));
        spn50Coins.setSpinnerModel (new IntegerSpinnerModel (0));
        spn5Coins.setSpinnerModel (new IntegerSpinnerModel (0));  
    }
    
    public void StartCmbAccountTypes(){
        List <String> numberDepositList=new ArrayList<>();
        ObservableList<String>items;
        for(int i=1;i<=listDeposit.size();i++){
            numberDepositList.add(String.valueOf(i));
        }
        items=FXCollections.observableArrayList(numberDepositList);
        cmbDepositNumber.setItems(items);
        numberDepositList.clear();
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
