/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import cr.ac.una.taskprogrammingii.controller.Controller;
import cr.ac.una.taskprogrammingii.model.Associated;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javafx.scene.image.ImageView;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import java.io.File;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class UserMaintenanceController extends Controller implements Initializable {

    @FXML
    private ImageView imgUserImage;
    @FXML
    private MFXButton btnExit;
    @FXML
    private MFXButton btbSave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onImageClicked(MouseEvent event) {
         FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
       
        if (selectedFile != null) {
            Image newImage = new Image(selectedFile.toURI().toString());
           imgUserImage.setImage(newImage);
        }
    }

    @FXML
    private void onActionBtnExit(ActionEvent event) {
    }

    @FXML
private void onActionBtnSearchWithFoil(ActionEvent event) {
//      String folio = txtFoil.getText(); 
//      
//    if (!folio.isEmpty()) { 
//        Associated associated = findAssociateByFolio(folio); 
//        if (associated != null) {
//  
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Confirmación");
//            alert.setHeaderText("Asociado encontrado por folio:");
//            alert.setContentText("Nombre: " + associated.getName() + " " + associated.getLastName()+ " " + associated.getSecondLastName() + "\n¿Deseas desplegar las cuentas de este asociado?");
//            
//            Optional<ButtonType> result = alert.showAndWait();
//            if (result.isPresent() && result.get() == ButtonType.OK) {
//                displayAssociatedAccounts(associated);
//            }
//        } else {
//            message.show(Alert.AlertType.ERROR, "Error", "No se encontró ningún asociado con el número de folio proporcionado.");
//        }
//    } else {
//        message.show(Alert.AlertType.ERROR, "Error", "Por favor, introduce un número de folio.");
//    }
}
    @Override
    public void initialize() {
        
    }
    
}
