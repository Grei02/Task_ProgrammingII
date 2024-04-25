/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;


import cr.ac.una.taskprogrammingii.model.Account;
import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.util.FlowController;
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
import cr.ac.una.taskprogrammingii.util.Mensaje;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class AddDavilitarAccountsController extends Controller implements Initializable {
    
   Mensaje message = new Mensaje();
   FileManager fileManager= new FileManager();
   Associated associated = new Associated();
   Boolean hasAmount=false;
   
   @FXML
    private AnchorPane root;
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
    @FXML
    private MFXButton btnSave;

    @FXML
    private void onDragDetectedFromAccountTypesTable(MouseEvent event) {
    String accountType = tbvAccountTypesTable.getSelectionModel().getSelectedItem();

    if (accountType != null) {
    Dragboard dragboard = tbvAccountTypesTable.startDragAndDrop(TransferMode.MOVE);
    ClipboardContent content = new ClipboardContent();
    content.putString(accountType);
    dragboard.setContent(content);

    tbvAccountTypesTable.getItems().remove(accountType);
    }
    event.consume();
    }

    @FXML
    private void onDragOverToUserAccountsTable(DragEvent event) {
    if (event.getGestureSource() != tbvUserAccountsTable && event.getDragboard().hasString()) {
    event.acceptTransferModes(TransferMode.MOVE);
    }
    event.consume();
    }

    @FXML
    private void onDragDroppedToUserAccountsTable(DragEvent event) {
    Dragboard dragboard = event.getDragboard();
    boolean success = false;

    if (dragboard.hasString()) {
    String accountType = dragboard.getString();
    tbvUserAccountsTable.getItems().add(accountType);
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
    tbvUserAccountsTable.getItems().remove(studentAccount);
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
    Account account = new Account(accountType,0, new ArrayList<>());
    tbvAccountTypesTable.getItems().add(accountType);
    success = true;
    }
    event.setDropCompleted(success);
    event.consume();
    }

    @FXML
    private void onActionBtnSearchWithFoil(ActionEvent event) {
    String folio = txtFoil.getText().trim().toUpperCase(); 

    if (!folio.isEmpty()) { 
    Associated associated = findAssociateByFolio(folio); 
    if (associated != null) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmación");
    alert.setHeaderText("Asociado encontrado por folio:");
    alert.setContentText("Nombre: " + associated.getName() + " " + associated.getLastName()+ " " + associated.getSecondLastName() + "\n¿Deseas desplegar las cuentas de este asociado?");
    initializeTable(associated);
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
     typesAccountsAvailable(associated);
    displayAssociatedAccounts(associated);
    }
    } else {
    message.show(Alert.AlertType.ERROR, "Error", "No se encontró ningún asociado con el número de folio proporcionado.");
    }
    } else {
    message.show(Alert.AlertType.ERROR, "Error", "Por favor, introduce un número de folio.");
    }
    }

    @FXML
    private void onActionBtnSearhWithName(ActionEvent event) {
    FlowController.getInstance().goViewInWindowModal("searchByNameView", stage, Boolean.FALSE);
    }

    @FXML
    private void onActionBtnSave(ActionEvent event) {
        createDeleteAccounts();
        resetScreen(); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resetScreen();
    }

    @Override
    public void initialize() {
        resetScreen();
    }
    
    public void createDeleteAccounts(){
        List<Associated> associatedList=new ArrayList<>();
        associatedList=fileManager.deserialize("ListAssociated.txt");
        searchAssociated(associatedList);
        if(associated!=null){
            List<String> userAccountsList = new ArrayList<>();
            List<String> availableAccountsList = new ArrayList<>();
            loadTableValues(userAccountsList,availableAccountsList);
            addAccount(userAccountsList);
            deleteAccount(availableAccountsList);
            fileManager.serialization(associatedList, "ListAssociated.txt");
            if(hasAmount){
            message.show(Alert.AlertType.WARNING, "Aviso", "No puedes deshabilitar una cuenta con monto.");
            hasAmount=false;
            }
        }
    }
    
    public void initializeTable(Associated associated){
        tbcAccountTypesTable.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        typesAccountsAvailable(associated);
        
        tbcUserAccountsTable.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        displayAssociatedAccounts( findAssociateByFolio(txtFoil.getText().trim().toUpperCase()));
    }
    
    public void typesAccountsAvailable(Associated associated){
        List<Account> accountList = associated.getAcountList();
        ObservableList<String> accountTypesObservableList = FXCollections.observableArrayList();
        List<String> accountTypes = fileManager.deserialize("accounts.txt");
        Boolean typeAvailable=false;

        if(accountTypes!=null && !accountTypes.isEmpty()){
            for(String type:accountTypes){
                if(accountList!=null && !accountList.isEmpty()){
                    for(Account account:accountList){
                        if(!type.equals(account.getType())){
                            accountTypesObservableList.add(type);
                            break;
                        }
                    }
                }
                accountTypesObservableList.add(type);
            }
            tbvAccountTypesTable.setItems(accountTypesObservableList);
        }
        
    }
    
    public void displayAssociatedAccounts(Associated associated) {
        List<Account> accountList = associated.getAcountList();
        ObservableList<String> accountData = FXCollections.observableArrayList();
        if(accountList!=null){
            for (Account account : accountList) {
            String accountInfo = account.getType();
            accountData.add(accountInfo);
            }
            tbvUserAccountsTable.setItems(accountData);
        }
        
    }

    private Associated findAssociateByFolio(String folio) {
        List<Associated> associatedList = fileManager.deserialize("ListAssociated.txt");
        for (Associated associated : associatedList) {
            if (folio.equals(associated.getFolio().trim().toUpperCase())) {
                enableButtons();
                return associated;
            }
        } 
        return null;
    }
    
    public void enableButtons(){
        tbvUserAccountsTable.setDisable(false);
        tbvAccountTypesTable.setDisable(false);
        btnSave.setDisable(false);
        btnSearchWithFoil.setDisable(true);
        btnSearchWithName.setDisable(true);
        txtFoil.setDisable(true);
    }

    public void loadTableValues(List<String> userAccountsList,List<String> availableAccountsList){
    for (Object item : tbvUserAccountsTable.getItems()) {
    userAccountsList.add(tbcUserAccountsTable.getCellData(item.toString()));
    }
    for (Object item : tbvAccountTypesTable.getItems()) {
    availableAccountsList.add(tbcAccountTypesTable.getCellData(item.toString()));
    }
    }

    public void  searchAssociated(List <Associated> associatedList){
        associated =new Associated();
        for(Associated compareAssociated:associatedList){
            if(compareAssociated.getFolio().equals(txtFoil.getText().trim().toUpperCase())){
            associated=compareAssociated;
            break;
            }
        }
    }

    public void addAccount(List <String> listTypeAccount){

    if(((associated.getAcountList()!=null) || (listTypeAccount!=null) ||(!associated.getAcountList().isEmpty()) || (!listTypeAccount.isEmpty()))){
    List <Account> listOriginalUserAccount=associated.getAcountList();
    Boolean accountExists= false;
    for(String typeAccountCompare: listTypeAccount){
        for(Account accountCompare:listOriginalUserAccount){
            if(typeAccountCompare.equals(accountCompare.getType())){
                accountExists=true;
                break;
            }
    }
    if(!accountExists){
    associated.addAccount(new Account(typeAccountCompare, 0, null));
    }
    accountExists=false;
    }
    }
    }

    public void deleteAccount(List<String> availableAccountsList){
    if(((associated.getAcountList()!=null) || (!availableAccountsList.isEmpty()) || (!associated.getAcountList().isEmpty())||(!availableAccountsList.isEmpty()))){
    List <Account> listOriginalUserAccount=associated.getAcountList();
    for(String typeAccountCompare: availableAccountsList){
    for(Account accountCompare:listOriginalUserAccount){ 
    if(typeAccountCompare.equals(accountCompare.getType())){
        if(accountCompare.getAmount()==0){
            listOriginalUserAccount.remove(accountCompare);
        }
        else{
            hasAmount=true;
        }
        break;
    }
    }
    }
    }

    }
    
    public void resetScreen(){
        txtFoil.setDisable(false);
        tbvUserAccountsTable.setDisable(true);
        tbvAccountTypesTable.setDisable(true);
        tbvAccountTypesTable.getItems().clear();
        tbvUserAccountsTable.getItems().clear();
        btnSave.setDisable(true);
        txtFoil.setText(null);

        btnSearchWithFoil.setDisable(false);
        btnSearchWithName.setDisable(false);
    }

    // Método para actualizar los datos del asociado en el archivo
    private void updateAssociatedDataInFile(Associated associated) {
    List<Associated> associatedList = fileManager.deserialize("ListAssociated.txt");

    // Buscamos al asociado por su número de folio y lo reemplazamos con el asociado actualizado
    for (int i = 0; i < associatedList.size(); i++) {
    if (associated.getFolio().equals(associatedList.get(i).getFolio())) {
    associatedList.set(i, associated);
    break;
    }
    }

    // Guardamos la lista actualizada de asociados en el archivo
    fileManager.serialization(associatedList, "ListAssociated.txt");
    }

}