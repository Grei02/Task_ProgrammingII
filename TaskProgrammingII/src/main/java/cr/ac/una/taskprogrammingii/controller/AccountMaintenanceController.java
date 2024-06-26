/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Account;
import cr.ac.una.taskprogrammingii.model.FileManager;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import javafx.scene.layout.AnchorPane;

public class AccountMaintenanceController extends Controller implements Initializable {
    
    Mensaje message = new Mensaje();
    private FileManager<Account> fileManager = new FileManager<>();
    @FXML
    private AnchorPane root;
    @FXML
    private TableView<Account> tbvAccountsList;
    @FXML
    private MFXButton btnDelete;
     @FXML
    private TableColumn<String, String> tbcAccountsColumn;
    @FXML
    private MFXButton btnrefreshWindown;
    @FXML
    private MFXButton btnExit;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tbcAccountsColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        List<Account> accounts = fileManager.deserialize("accounts.txt");
        ObservableList<Account> accountsObservableList = FXCollections.observableArrayList(accounts);
        tbvAccountsList.setItems(accountsObservableList);
    }
    
     @Override
    public void initialize() {
    }

    @FXML
private void OnActionBtnDelete(ActionEvent event) {
    int selectedIndex = tbvAccountsList.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("¿Está seguro de que desea eliminar esta cuenta?");
        alert.setHeaderText(null);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ObservableList<Account> accounts = tbvAccountsList.getItems();
            accounts.remove(selectedIndex);
            fileManager.serializationRemove(accounts,"accounts.txt");
        }
    }
}
    @FXML
    private void OnActionBtnRefreshWindown(ActionEvent event) {
        List<Account> updatedAccounts = fileManager.deserialize("accounts.txt");
    ObservableList<Account> currentAccounts = tbvAccountsList.getItems();
    
    if (!updatedAccounts.equals(currentAccounts)) {
        currentAccounts.setAll(updatedAccounts);
        message.show(Alert.AlertType.INFORMATION, "Confirmacion", "Los datos se han actualizado correctamente.");
  
    } else {
        message.show(Alert.AlertType.INFORMATION, "Confirmacion", "No hay actualizaciones registradas.");
    }
    }

    @FXML
    private void onActionBtnExit(ActionEvent event) {
    }
   
}