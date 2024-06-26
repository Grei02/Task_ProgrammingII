/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Account;
import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.Deposits;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import io.github.palexdev.materialfx.controls.MFXSpinner;
import io.github.palexdev.materialfx.controls.models.spinner.IntegerSpinnerModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class DepositAssociatedController extends Controller implements Initializable   {
    private Deposits deposit=new Deposits();
    private FileManager fileManager= new FileManager();
    private Mensaje message=new Mensaje();
    private List<Deposits> listDeserialization= new ArrayList<>();
    private Associated associated;
    
        @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;
    
    @FXML
    private AnchorPane root;
    
    @FXML
    private MFXComboBox<String> cmbAccountTypes;
    
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
        String typeAccouny = cmbAccountTypes.getValue();
        setAmounts();
        deposit.calculateTotal();
        if(deposit.getTotal()!=0){
            deposit.setTypeAccount(typeAccouny);
            listDeserialization=fileManager.deserialize("DepositList.txt");
            listDeserialization.add(deposit);
            fileManager.serialization(listDeserialization,"DepositList.txt");
            resetScreen();
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "No estas depositando ningun monto.");
        }
    }
    
     @FXML
    void onActionCmbAccountTypes(ActionEvent event) {
        disableSpinner(false);
        btnSave.setDisable(false);
    }
    
    @FXML
    void onActiontxtFolioUser(ActionEvent event) {
        
        if(searchAssociated ()){
            cmbAccountTypes.setDisable(false);
            txtFolioUser.setDisable(true);
            StartCmbAccountTypes();
            message.show(Alert.AlertType.INFORMATION, "Confirmacion", "Se ha encontrado el asociado, ahora por favor escoger la cuenta a la que desea hacer el deposito");
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "No se ha encontrado ningun asociado, intente de nuevo.");
            txtFolioUser.setText(null);
        }
    }
    
    public Boolean searchAssociated (){
          deposit.setFolio(txtFolioUser.getText().trim().toUpperCase());
           List <Associated> associatedList= fileManager.deserialize("ListAssociated.txt");
            for(Associated compareAssociated:associatedList){
                if(compareAssociated.getFolio().equals(deposit.getFolio())){
                    associated=compareAssociated;
                    return true;
                }
            }
            return false;
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

    public void resetScreen(){
    initializeSpinner();
    cmbAccountTypes.setDisable(true);
    cmbAccountTypes.setValue(null);
    cmbAccountTypes.getSelectionModel().clearSelection();
    btnSave.setDisable(true);
    txtFolioUser.setText(null);
    txtFolioUser.setDisable(false);
    cmbAccountTypes.setDisable(true);
    txtTotalAmount.setDisable(true);
    txtTotalAmount.setText("0");
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
    List<Account> accountAssciatedList=associated.getAcountList();
    List <String> typeAccountList=new ArrayList<>();
    ObservableList<String>items=null;
    if(accountAssciatedList!=null){
        for(Account currentAccount:accountAssciatedList){
        typeAccountList.add(currentAccount.getType());
        }
        items=FXCollections.observableArrayList(typeAccountList);
        cmbAccountTypes.setItems(items);
    }
    else{
        message.show(Alert.AlertType.WARNING, "Aviso", "Este asociado no tiene cuentas, crea una cuenta para asi poder depositar en ella.");
    }

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
