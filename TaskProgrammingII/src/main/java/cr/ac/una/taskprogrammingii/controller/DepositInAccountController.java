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
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class DepositInAccountController extends Controller implements Initializable {
    private Deposits deposit=new Deposits();
    private FileManager fileManager= new FileManager();
    private Mensaje message=new Mensaje();
    
        @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;
    
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

    ObservableList <String> items=null;
    
    @FXML
    void onActionBtnCancel(ActionEvent event) {
        initializeSpinner();
        txtFolioUser.setText(null);
        enableSpinner(true);
    }
    
    @FXML
    void onActionbtnSave(ActionEvent event) {
        
    }
    
    @FXML
    void onActiontxtFolioUser(ActionEvent event) {
        String folioAssociated=txtFolioUser.getText().trim();
       folioAssociated = folioAssociated.toUpperCase();
        List <Associated> associatedList= fileManager.deserialize("ListAssociated.txt");
        for(Associated compareAssociated:associatedList){
            if(compareAssociated.getFolio().equals(folioAssociated)){
                deposit.setAssociated(compareAssociated);
                break;
            }
        }
        if(deposit.getAssociated()!=null){
            enableSpinner(false);
            System.out.println("Nombre: "+deposit.getAssociated().getName());
            message.show(Alert.AlertType.INFORMATION, "Confirmacion", "Se ha encontrado el asociado, ahora por favor escoger la cuenta a la que desea hacer el deposito");
            StartCmbAccountTypes();
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "No se ha encontrado ningun asociado, intente de nuevo");
            txtFolioUser.setText(null);
        }
    }
    
    public void enableSpinner(Boolean enable){
        txtFolioUser.setDisable(!enable);
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
        this.spn10000Bills.setSpinnerModel (new IntegerSpinnerModel (0));
        this.spn1000Bills.setSpinnerModel (new IntegerSpinnerModel (0));
        this.spn100Coins.setSpinnerModel (new IntegerSpinnerModel (0));
        this.spn10Coins.setSpinnerModel (new IntegerSpinnerModel (0));
        this.spn20000Bills.setSpinnerModel (new IntegerSpinnerModel (0));
        this.spn2000Bills.setSpinnerModel (new IntegerSpinnerModel (0));
        this.spn25Coins.setSpinnerModel (new IntegerSpinnerModel (0));
        this.spn5000Bills.setSpinnerModel (new IntegerSpinnerModel (0));
        this.spn500Coins.setSpinnerModel (new IntegerSpinnerModel (0));
        this.spn50Coins.setSpinnerModel (new IntegerSpinnerModel (0));
        this.spn5Coins.setSpinnerModel (new IntegerSpinnerModel (0));  
    }
    
    public void StartCmbAccountTypes(){
        List<Account> accountAssciatedList=deposit.getAssociated().getAcountList();
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
        
    }    
    
    @Override
    public void initialize() {
        initializeSpinner();
        enableSpinner(true);
        
//      this.spines.setSpinnerModel(new IntegerSpinnerModel (0));
//      List <String> list=new ArrayList<>();
//      list.add("Hola");
//      list.add("Sofia");
//      list.add("Bejarano");
//      items=FXCollections.observableArrayList(list);
//      cmbAccountTypes.setItems(items);
    }
    
}
