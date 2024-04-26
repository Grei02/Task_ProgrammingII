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
    
    private Associated generalAssociate=new Associated();
    private Deposits deposit=new Deposits();
    private FileManager fileManager= new FileManager();
    private List<Deposits> listDeposit= new ArrayList<>();
    private List<Deposits> listDeserialization= new ArrayList<>();
    private Account accountChose=new Account();
    
   @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;
    
    @FXML
    private MFXComboBox<String> cmbDepositNumber;
    
    @FXML
    private MFXComboBox<String> cmbFolios;

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
          List<Associated> associatedList=new ArrayList<>();
          setAmounts();
          deposit.calculateTotal();
            if(deposit.getTotal()!=0){
             associatedList=fileManager.deserialize("ListAssociated.txt");
             searchChosenAccount(associatedList);
             addTransfer();
             fileManager.serialization(associatedList,"ListAssociated.txt");
             listDeserialization=fileManager.deserialize("DepositList.txt");
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
    void onActionCmbDepositNumber(ActionEvent event) {
        if(cmbDepositNumber.getValue()!=null){
         int depositNumber=Integer.parseInt(cmbDepositNumber.getValue());
         deposit=listDeposit.get(depositNumber-1);
         txtUserName.setText(generalAssociate.getName()+generalAssociate.getLastName()+
         generalAssociate.getSecondLastName());
         txtTypeAccount.setText(deposit.getTypeAccount());
         loadDepositValues();
         disableSpinner(false);
         btnSave.setDisable(false);
        }
    }
    
    @FXML
    void onActionCmbFolios(ActionEvent event) {
            cmbFolios.setDisable(true);
            cmbDepositNumber.setDisable(false);
            searchDeposit();
            StartCmbAccountTypes();
            deposit.setFolio(cmbFolios.getValue());
            List<Associated> associatedList=fileManager.deserialize("ListAssociated.txt");
            generalAssociate = searchAssociated(associatedList);
    }
    
    public void searchChosenAccount(List<Associated> associatedList){
       List<Account> listAccount= searchAssociated(associatedList).getAcountList();
        if(listAccount!=null){
            for(int i=0;i<listAccount.size();i++){
                if(listAccount.get(i).getType().equals(deposit.getTypeAccount())){
                      accountChose=listAccount.get(i);
                      break;
                  }
            }
        }
   }
    
    public void addTransfer(){
         List<Transfer> listTransfer=accountChose.getListTransfer();
         if(listTransfer==null || listTransfer.isEmpty()){
             listTransfer=new ArrayList<>();
         }
         listTransfer.add(new Transfer("Deposito", String.valueOf(deposit.getTotal())));
         accountChose.setListTransfer(listTransfer);
         accountChose.depositAmount(deposit.getTotal());
         
    }
    
    public Associated searchAssociated(List <Associated> associatedList){
        Associated associated =new Associated();
        for(Associated compareAssociated:associatedList){
            if(compareAssociated.getFolio().equals(deposit.getFolio())){
                associated=compareAssociated;
                break;
            }
        }
        return associated;
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
    
    public void searchDeposit(){
        listDeposit.clear();
        listDeserialization=fileManager.deserialize("DepositList.txt");
        if(listDeserialization!=null){
            String folio=cmbFolios.getValue();
            for(Deposits comparisonDeposit:listDeserialization){
                if(comparisonDeposit.getFolio().equals(folio)){
                    listDeposit.add(comparisonDeposit);
                }
            }
        }
    }
    
    public void resetScreen(){
        initializeSpinner();
        cmbFolios.setValue(null);
        cmbFolios.getSelectionModel().clearSelection();
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
         StartCmbFolios();
         cmbFolios.setDisable(false);
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
    
    public void StartCmbFolios(){
           listDeserialization=fileManager.deserialize("DepositList.txt");
           if(listDeserialization!=null){
            List <String> listFolio=new ArrayList<>();
            ObservableList<String>items;
            for(Deposits deposit:listDeserialization){
                if (checkEnteredFolio(listFolio,deposit.getFolio())){
                    listFolio.add(deposit.getFolio());
                    }
                }
                items=FXCollections.observableArrayList(listFolio);
                cmbFolios.setItems(items);
        }
    }
    
    public Boolean checkEnteredFolio (List <String> listFolio,String folio){
        if(listFolio!=null){
            for(String compareFolio:listFolio){
            if(compareFolio.equals(folio)){
                return false;
             }
          }
        }
        return true;
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
