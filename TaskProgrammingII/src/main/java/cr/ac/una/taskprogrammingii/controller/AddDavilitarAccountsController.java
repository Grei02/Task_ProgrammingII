/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class AddDavilitarAccountsController implements Initializable {

    @FXML
    private MFXButton btnSearch;
    @FXML
    private MFXButton btnSearchFoil;
    @FXML
    private MFXLegacyTableView<?> tbvAccountTypesTable;
    @FXML
    private TableColumn<?, ?> tbcAccountTypesTable;
    @FXML
    private MFXLegacyTableView<?> tbvUserAccountsTable;
      @FXML
    private TableColumn<?, ?>  tbcUserAccountsTable;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onDragDetectedFromAccountTypesTable(MouseEvent event) {
    }

    @FXML
    private void onDragOverToUserAccountsTable(DragEvent event) {
    }

    @FXML
    private void onDragDroppedToUserAccountsTable(DragEvent event) {
    }

    @FXML
    private void onDragDetectedFromUserAccountsTable(MouseEvent event) {
    }

    @FXML
    private void onDragOverUserAccountsTable(DragEvent event) {
    }

    @FXML
    private void onDragDroppedToAccountTypesTable(DragEvent event) {
    }
    
}
