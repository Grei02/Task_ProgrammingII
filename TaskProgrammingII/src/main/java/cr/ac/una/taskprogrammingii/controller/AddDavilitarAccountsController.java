/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Account;
import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
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
import java.util.Optional;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
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
    @FXML
    private MFXTextField txtFoil;
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
        
        if (accountType != null) {
            Dragboard dragboard = tbvAccountTypesTable.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(accountType);
            dragboard.setContent(content);
        }
   
        event.consume();
    }

    @FXML
    private void onDragOverToUserAccountsTable(DragEvent event) {
        if (event.getGestureSource() != tbvUserAccountsTable && event.getDragboard().hasString()) {
            System.out.println("Modo de transferencia aceptado");
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();
    }

    @FXML
    private void onDragDroppedToUserAccountsTable(DragEvent event) {
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
      String folio = txtFoil.getText(); 
      
    if (!folio.isEmpty()) { 
        Associated associated = findAssociateByFolio(folio); 
        if (associated != null) {
  
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("Asociado encontrado por folio:");
            alert.setContentText("Nombre: " + associated.getName() + " " + associated.getLastName()+ " " + associated.getSecondLastName() + "\n¿Deseas desplegar las cuentas de este asociado?");
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                displayAssociatedAccounts(associated);
            }
        } else {
            message.show(Alert.AlertType.ERROR, "Error", "No se encontró ningún asociado con el número de folio proporcionado.");
        }
    } else {
        message.show(Alert.AlertType.ERROR, "Error", "Por favor, introduce un número de folio.");
    }
}

private void displayAssociatedAccounts(Associated associated) {
    List<Account> accountList = associated.getAcountList();
   
    ObservableList<String> accountData = FXCollections.observableArrayList();

    for (Account account : accountList) {
        String accountInfo = "Tipo de cuenta: " + account.getType();
        accountData.add(accountInfo);
    }
    tbvUserAccountsTable.setItems(accountData);
}


private Associated findAssociateByFolio(String folio) {
    List<Associated> associatedList = fileManager.deserialize("ListAssociated.txt");
    for (Associated associated : associatedList) {
        if (folio.equals(associated.getFolio())) {
            return associated;
        }
    }
    return null;
}
@FXML
private void onActionBtnSearhWithName(ActionEvent event) {
//    TextInputDialog dialog = new TextInputDialog();
//    dialog.setTitle("Buscar por nombre");
//    dialog.setHeaderText("Introduce el nombre del asociado:");
//    Optional<String> result = dialog.showAndWait();
//    result.ifPresent(name -> {
//        Associated associated = findAssociateByName(name);
//        if (associated != null) {
//            System.out.println("Asociado encontrado por nombre: " + associated.getName() + " " + associated.getLastName());
//        } else {
//            System.out.println("No se encontró ningún asociado con el nombre proporcionado.");
//        }
//    });
}

//private Associated findAssociateByName(String name) {
//    List<Associated> associatedList = fileManager.deserialize("ListAssociated.txt");
//    for (Associated associated : associatedList) {
//        if (name.equalsIgnoreCase(associated.getName()) || name.equalsIgnoreCase(associated.getLastName())) {
//            return associated;
//        }
//    }
//    return null;
//}

}
