/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.FileManager;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class SearchByNameController extends Controller implements Initializable {
 FileManager fileManager= new FileManager();
    @FXML
    private MFXTextField txtName;
    @FXML
    private MFXTextField txtFirstSurname;
    @FXML
    private MFXTextField txtSecondSurname;
    @FXML
    private MFXTextField txtFoil;
    @FXML
    private MFXButton btnSearch;
    @FXML
    private MFXButton btnAcept;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @Override
    public void initialize() {
       resetScreen();
    }
    
    public void resetScreen(){
        txtFoil.setDisable(true);
        txtFoil.setEditable(false);
    }

    @FXML
    private void onActionBtnSearch(ActionEvent event) {
        String name = txtName.getText().trim();
    String firstSurname = txtFirstSurname.getText().trim();
    String secondSurname = txtSecondSurname.getText().trim();
   
    String foil = searchFoilByFullName(name, firstSurname, secondSurname);

    txtFoil.setText(foil);
    txtFoil.setDisable(false); 
    }

    private String searchFoilByFullName(String name, String firstSurname, String secondSurname) {
        List<Associated> associatedList = fileManager.deserialize("ListAssociated.txt");
    for (Associated associated : associatedList) {
        if (name.equalsIgnoreCase(associated.getName()) &&
            firstSurname.equalsIgnoreCase(associated.getLastName()) &&
            secondSurname.equalsIgnoreCase(associated.getSecondLastName())) {
            return associated.getFolio();
        }
    }
    return "No se encontro el folio"; 
    }

    @FXML
    private void onActionBtnAcept(ActionEvent event) {
    stage.close();
    }
    }
    

