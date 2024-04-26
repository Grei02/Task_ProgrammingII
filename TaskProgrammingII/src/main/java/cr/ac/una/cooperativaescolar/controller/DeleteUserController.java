/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.cooperativaescolar.controller;

import cr.ac.una.cooperativaescolar.model.Associated;
import cr.ac.una.cooperativaescolar.model.FileManager;
import cr.ac.una.cooperativaescolar.util.Mensaje;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class DeleteUserController extends Controller implements Initializable {
    FileManager fileManager=new FileManager();
    List<Associated> listAssocieated=new ArrayList<>();
    Associated associated=new Associated();
    private Mensaje message=new Mensaje();

   @FXML
    private Button btnDeleteUser;

    @FXML
    private Button btnPdf;

    @FXML
    private Button btnSaveUser;

    @FXML
    private ImageView imvUserPhoto;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtFolio;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtName;

    @FXML
    void onActionBtnDeleteUser(ActionEvent event) {
        
    }

    @FXML
    void onActionBtnSaveUser(ActionEvent event) {
        
    }

    @FXML
    void onActionPdf(ActionEvent event) {
        
    }

    @FXML
    void onActionTxtFolio(ActionEvent event) {
        if(searchAssociated()){
            loadDataAssociated();
        }
        else{
            message.show(Alert.AlertType.WARNING, "Aviso", "No se ha encontrado ningun asociado, intente de nuevo.");
            txtFolio.setText(null);
        }
    }
    
     public Boolean searchAssociated(){
        String folio=txtFolio.getText().trim().toUpperCase();
        List <Associated> associatedList= fileManager.deserialize("ListAssociated.txt");
        for(Associated compareAssociated:associatedList){
            if(compareAssociated.getFolio().equals(folio)){
                associated=compareAssociated;
                return true;
            }
        }
        return false;
    }
     
     public void loadDataAssociated(){
        txtAge.setText(associated.getAge());
        txtName.setText(associated.getName());
        txtLastName.setText(associated.getLastName()+" "+associated.getSecondLastName());
        Image image=new Image(associated.getAddressPhotography());
        imvUserPhoto.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtAge.setDisable(true);
        txtLastName.setDisable(true);
        txtName.setDisable(true);
    }    

    @Override
    public void initialize() {
        
    }
    
}
