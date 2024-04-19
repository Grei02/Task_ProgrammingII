/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Account;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import javafx.scene.control.TableColumn;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class AddDavilitarAccountsController extends Controller implements Initializable {
    
   Mensaje message = new Mensaje();
   FileManager fileManager= new FileManager();
   
    @FXML
    private MFXLegacyTableView<String> tbvAccountTypesTable;
 @FXML
      private TableColumn<String, String> tbcAccountTypesTable;
    @FXML
    private MFXLegacyTableView<String> tbvUserAccountsTable;
@FXML
     private TableColumn<String, String>  tbcUserAccountsTable;
    @FXML
    private MFXButton btnSearchWithFoil;
    @FXML
    private MFXButton btnSearchWithName;
    /**
     * Initializes the controller class.
     */
    @Override
public void initialize(URL url, ResourceBundle rb) {
    
    tbcAccountTypesTable.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
    
    List<String> accountTypes = fileManager.deserialize("accounts.txt");
    ObservableList<String> accountTypesObservableList = FXCollections.observableArrayList(accountTypes);
    tbvAccountTypesTable.setItems(accountTypesObservableList);
  
    tbcUserAccountsTable.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
   
    ObservableList<String> userAccountsObservableList = FXCollections.observableArrayList();
    
    tbvUserAccountsTable.setItems(userAccountsObservableList);
}

 @Override
    public void initialize() {
    }

    @FXML
    private void onDragDetectedFromAccountTypesTable(MouseEvent event) {
        String accountType = tbvAccountTypesTable.getSelectionModel().getSelectedItem();
        
        System.out.println("Arrastre detectado desde la tabla de tipos de cuenta");
        
        if (accountType != null) {
            System.out.println("Tipo de cuenta seleccionado: " + accountType);
            Dragboard dragboard = tbvAccountTypesTable.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(accountType);
            dragboard.setContent(content);
        } else {
            System.out.println("No se ha seleccionado ningún tipo de cuenta");
        }
        
        event.consume();
    }

    @FXML
    private void onDragOverToUserAccountsTable(DragEvent event) {
        System.out.println("Arrastre sobre la tabla de cuentas de usuario");
        
        if (event.getGestureSource() != tbvUserAccountsTable && event.getDragboard().hasString()) {
            System.out.println("Modo de transferencia aceptado");
            event.acceptTransferModes(TransferMode.MOVE);
        }
        
        event.consume();
    }

    @FXML
    private void onDragDroppedToUserAccountsTable(DragEvent event) {
        System.out.println("Soltado en la tabla de cuentas de usuario");
        
        Dragboard dragboard = event.getDragboard();
        boolean success = false;
        
        if (dragboard.hasString()) {
           
            System.out.println("Tipo de cuenta soltado: " + dragboard.getString());
            tbvUserAccountsTable.getItems().add(dragboard.getString());
            success = true;
        }
        
        event.setDropCompleted(success);
        event.consume();
    }

@FXML
private void onDragDetectedFromUserAccountsTable(MouseEvent event) {

    String studentAccount = tbvUserAccountsTable.getSelectionModel().getSelectedItem();
    
    if (studentAccount != null) {
 
        Dragboard dragboard = tbvUserAccountsTable.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putString(studentAccount);
        dragboard.setContent(content);
    }
    
    event.consume();
}

@FXML
private void onDragOverFromAccountTypesTable(DragEvent event) {
    
    if (event.getGestureSource() != tbvAccountTypesTable && event.getDragboard().hasString()) {
        event.acceptTransferModes(TransferMode.MOVE);
    }
    event.consume();
}

@FXML
private void onDragDroppedFromAccountTypesTable(DragEvent event) {

    Dragboard dragboard = event.getDragboard();
    boolean success = false;
   
    if (dragboard.hasString()) {

        String accountType = dragboard.getString();
       
        tbvAccountTypesTable.getItems().add(accountType);
        
        success = true;
    }
   
    event.setDropCompleted(success);
    event.consume();
}

    @FXML
    private void onActionBtnSearchWithFoil(ActionEvent event) {
    }

    @FXML
    private void onActionBtnSearhWithName(ActionEvent event) {
    }
}
