/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.controller.Controller;
import cr.ac.una.taskprogrammingii.util.AppContext;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.utils.SwingFXUtils;
//import java.awt.image.BufferedImage;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class EditWindowController extends Controller implements Initializable {
   Mensaje message = new Mensaje();
    @FXML
    private MFXTextField txtNameCoop;
    @FXML
    private MFXButton btnSave;
    @FXML
    private ImageView imgLogoCoop;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //String coopName = (String) AppContext.getInstance().get("coopName");
    //Image coopLogo = (Image) AppContext.getInstance().get("coopLogo");
    }
    //se debe crear-consultar-
  @FXML
private void onActionBtnSave(ActionEvent event) {
    String newName = txtNameCoop.getText();
   
    if (!newName.isEmpty() && imgLogoCoop.getImage() != null) {
        try {
            Image image = imgLogoCoop.getImage();
            String fileName = "logo.png";
            
           String destinationPath = System.getProperty("user.dir") + "/resources/" + fileName;
            // Crear el archivo de destino
            File outputFile = new File(destinationPath);
            
            // Verificar si se puede escribir en el directorio de destino
            if (!outputFile.getParentFile().exists() && !outputFile.getParentFile().mkdirs()) {
                // No se pudo crear el directorio de destino
                throw new IOException("No se puede crear el directorio de destino");
            }
            
            // Escribir la imagen en el archivo
            if (!ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", outputFile)) {
                // La escritura de la imagen falló
                throw new IOException("La escritura de la imagen falló");
            }
            
            // Mostrar mensaje de confirmación
            message.show(Alert.AlertType.INFORMATION, "Confirmación", "Los cambios se han guardado exitosamente.");
 
            // Almacenar el nombre de la cooperativa en el contexto de la aplicación
            AppContext.getInstance().set("coopName", newName);
            
            // No es recomendable almacenar la imagen en el contexto de la aplicación debido a su tamaño
            // AppContext.getInstance().set("coopLogo", image);
        } catch (IOException e) {
            // Manejar la excepción
            e.printStackTrace();
            message.show(Alert.AlertType.ERROR, "Error", "Error al guardar la imagen: " + e.getMessage());
        }
    } else {
        // Mostrar mensajes de error si el nombre de la cooperativa o la imagen están ausentes
        if (newName.isEmpty() && imgLogoCoop.getImage() == null) {
            message.show(Alert.AlertType.ERROR, "Error", "Falta ingresar el nombre de la cooperativa y seleccionar un logo.");
        } else if (newName.isEmpty()) {
            message.show(Alert.AlertType.ERROR, "Error", "Falta ingresar el nombre de la cooperativa.");
        } else {
            message.show(Alert.AlertType.ERROR, "Error", "Falta seleccionar un logo.");
        }
    }
}
    @FXML
    private void onImageClicked(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
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

    
