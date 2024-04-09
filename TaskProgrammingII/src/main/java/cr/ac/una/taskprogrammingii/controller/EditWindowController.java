/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.utils.SwingFXUtils;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.text.html.ImageView;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class EditWindowController extends Controller implements Initializable {

    @FXML
    private MFXButton btnSave;
//    @FXML
//    private MFXTextField txtNameCoop;
//    @FXML
//    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @Override
    public void initialize() {
       }

    @FXML
    private void onActionBtnSave(ActionEvent event) {
       
    }
}


    
//    @FXML
//    private void onImageClicked(MouseEvent event) {
//        FileChooser fileChooser = new FileChooser();
//    fileChooser.setTitle("Seleccionar Imagen");
//    fileChooser.getExtensionFilters().addAll(
//            new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif")
//    );
//        FileChooser selectedFile = fileChooser.showOpenDialog(imageView.getScene().getWindow());
////    if (selectedFile != null) {
////        try {
//            BufferedImage bufferedImage = ImageIO.read(selectedFile);
//            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
//            imageView.setImage(image);
//        } catch (IOException e) {
//            e.printStackTrace();
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("No se pudo cargar la imagen");
//            alert.setContentText("Ocurrió un error al intentar cargar la imagen.");
//            alert.showAndWait();
//        }
//    } else {
//        Alert alert = new Alert(AlertType.WARNING);
//        alert.setTitle("Advertencia");
//        alert.setHeaderText("No se ha seleccionado ninguna imagen");
//        alert.setContentText("Por favor, selecciona una imagen.");
//        alert.showAndWait();


