/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Deposits;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXSpinner;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class MailboxStudentViewController extends Controller implements Initializable {
    
    private Deposits deposit=new Deposits();
    private FileManager fileManager= new FileManager();
    private List<Deposits> listDeserialization= new ArrayList<>();
    private Mensaje message=new Mensaje();
    
   @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

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
    void onActionBtnCancel(ActionEvent event) {

    }

    @FXML
    void onActionbtnSave(ActionEvent event) {

    }

    @FXML
    void onActiontxtFolioUser(ActionEvent event) {
        if(searchDeposit()){
            
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "Este folio no coincide con ningun asociado.");
        }
    }

    @FXML
    void onMouseClickedSpn10000Bills(MouseEvent event) {

    }

    @FXML
    void onMouseClickedSpn1000Bills(MouseEvent event) {

    }

    @FXML
    void onMouseClickedSpn100Coins(MouseEvent event) {

    }

    @FXML
    void onMouseClickedSpn10Coins(MouseEvent event) {

    }

    @FXML
    void onMouseClickedSpn20000Bills(MouseEvent event) {

    }

    @FXML
    void onMouseClickedSpn2000Bills(MouseEvent event) {

    }

    @FXML
    void onMouseClickedSpn25Coins(MouseEvent event) {

    }

    @FXML
    void onMouseClickedSpn5000Bills(MouseEvent event) {

    }

    @FXML
    void onMouseClickedSpn500Coins(MouseEvent event) {

    }

    @FXML
    void onMouseClickedSpn50Coins(MouseEvent event) {

    }

    @FXML
    void onMouseClickedSpn5Coins(MouseEvent event) {

    }
    
    public Boolean searchDeposit(){
        listDeserialization=fileManager.deserialize("DepositList.txt");
        String folio=txtFolioUser.getText().trim();
        folio=folio.toUpperCase();
        
        for(Deposits comparisonDeposit:listDeserialization){
            if(comparisonDeposit.getAssociated().getFolio().equals(folio)){
                deposit=comparisonDeposit;
                return true;
            }
        }
        return false;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        disableSpinner(true);
        txtTotalAmount.setDisable(true);
        txtTypeAccount.setDisable(true);
    }    

    @Override
    public void initialize() {
            
    }
    
}
