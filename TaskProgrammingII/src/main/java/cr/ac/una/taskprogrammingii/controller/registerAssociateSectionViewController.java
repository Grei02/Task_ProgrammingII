/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.util.FlowController;
import cr.ac.una.taskprogrammingii.util.Mensaje;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class registerAssociateSectionViewController extends Controller implements Initializable {
    
     private Associated associated=new Associated();
     private FileManager fileManager= new FileManager();
     private Mensaje message=new Mensaje();
     
    @FXML
    private Button btnSave;

    @FXML
    private Button btnTakePhoto;

    @FXML
    private ImageView imvUserImage;

    @FXML
    private TextField txtUserAge;

    @FXML
    private TextField txtUserLastName;

    @FXML
    private TextField txtuserName;

    @FXML
    void onActionBtnTakePhoto(ActionEvent event) {
        
    }
    
    @FXML
    void onActionbtnSave(ActionEvent event) {
        
        associated.setName(txtuserName.getText());
        associated.setLastName(txtUserLastName.getText());
        associated.setAge(txtUserAge.getText());
        
         if (!associated.getName().isBlank() && !associated.getLastName().isBlank() && !associated.getAge().isBlank()) {
             fileManager.serialization(associated,"ListAssociated.txt");
             message.show(Alert.AlertType.INFORMATION, "Confirmacion", "Te has registrado existosamente");

        }
        else{
             FlowController.getInstance().goViewInWindow("PhotographyView");
             message.show(Alert.AlertType.WARNING, "Alerta", "Has dejado un espacio en blanco, por favor llenalo o no podras registarte.");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void initialize() {
    }

}
