/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.utils.SwingFXUtils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javafx.scene.image.ImageView;
import cr.ac.una.taskprogrammingii.util.Mensaje;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class EditWindowController extends Controller implements Initializable {
   Mensaje message;
    @FXML
    private MFXTextField txtNameCoop;
    @FXML
    private MFXButton btnSave;
    @FXML
    private ImageView imgLogoCoop;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onActionBtnSave(ActionEvent event) {
    String newName = txtNameCoop.getText();
   
    if (!newName.isEmpty() && imgLogoCoop.getImage() != null) {
        guardarCambios(newName, imgLogoCoop.getImage());
         message.show(Alert.AlertType.INFORMATION, "Confirmacion", "Los cambios se han guardado exitosamente.");
      
    } else {
        if (newName.isEmpty() && imgLogoCoop.getImage() == null) {
             message.show(Alert.AlertType.ERROR, "Error:", "Falta ingresar el nombre de la cooperativa y seleccionar un logo.");
        } else if (newName.isEmpty()) {
             message.show(Alert.AlertType.ERROR, "Error:", "Falta ingresar el nombre de la cooperativa.");
        } else {
             message.show(Alert.AlertType.ERROR, "Error:", "Falta seleccionar un logo.");
        }
    }
}
    
private void guardarCambios(String nombre, Image logo) {
    System.out.println("Nombre de la cooperativa guardado: " + nombre);
    System.out.println("Logo de la cooperativa guardado.");
}

    @FXML
    private void onImageClicked(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
       // fileChooser.setTitle("Seleccione una imagen");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
       
        if (selectedFile != null) {
            Image newImage = new Image(selectedFile.toURI().toString());
            imgLogoCoop.setImage(newImage);
        }
    }
    @Override
    public void initialize() {
    }
}

    
