/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

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
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class DepositInAccountController extends Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    //@FXML
    //private MFXSpinner<Integer> spines;
    
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

    ObservableList <String> items=null;
    
    public void initializeSpinner(){
        this.spn10000Bills.setSpinnerModel(new IntegerSpinnerModel (0));
        this.spn1000Bills.setSpinnerModel(new IntegerSpinnerModel (0));
        this.spn100Coins.setSpinnerModel(new IntegerSpinnerModel (0));
        this.spn10Coins.setSpinnerModel(new IntegerSpinnerModel (0));
        this.spn20000Bills.setSpinnerModel(new IntegerSpinnerModel (0));
        this.spn2000Bills.setSpinnerModel(new IntegerSpinnerModel (0));
        this.spn25Coins.setSpinnerModel(new IntegerSpinnerModel (0));
        this.spn5000Bills.setSpinnerModel(new IntegerSpinnerModel (0));
        this.spn500Coins.setSpinnerModel(new IntegerSpinnerModel (0));
        this.spn50Coins.setSpinnerModel(new IntegerSpinnerModel (0));
        this.spn5Coins.setSpinnerModel(new IntegerSpinnerModel (0));  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @Override
    public void initialize() {
        initializeSpinner();
      // this.spines.setSpinnerModel(new IntegerSpinnerModel (0));
//      List <String> list=new ArrayList<>();
//      list.add("Hola");
//      list.add("Sofia");
//      list.add("Bejarano");
//      items=FXCollections.observableArrayList(list);
//      cmbAccountTypes.setItems(items);
      
      
    }
    
}
