/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;


import cr.ac.una.taskprogrammingii.model.Account;
import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author USUARIO PZ UNA
 */
public class UserMaintenenceController extends Controller  implements Initializable {

    @FXML
    private MFXTextField txtFoil;
    @FXML
    private MFXButton btnSearch;
    @FXML
    private MFXButton btnExit;
    @FXML
    private MFXButton btnSave;
    @FXML
    private ImageView imgUser;
    
   Mensaje message = new Mensaje();
   FileManager fileManager= new FileManager();
   Associated associated = new Associated();

    Boolean isFoil=false;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
  public void cleanComponents(){
        txtFoil.setText(null);
        imgUser.setImage(null);
    }

    @FXML
    private void onActionBtnSearch(ActionEvent event) {
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
                displayAssociatedImage(associated);
                isFoil=true;
            }
        } else {
            message.show(Alert.AlertType.ERROR, "Error", "No se encontró ningún asociado con el número de folio proporcionado.");
        }
    } else {
        message.show(Alert.AlertType.ERROR, "Error", "Por favor, introduce un número de folio.");
    }
    }

    @FXML
    private void onImageClicked(MouseEvent event) {
        if(isFoil){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
       
        if (selectedFile != null) {
            Image newImage = new Image(selectedFile.toURI().toString());
            imgUser.setImage(newImage);
        }
        }
        else{
            message.show(Alert.AlertType.WARNING, "Advertencia", "Debes ingresar primero el folio del asociado.");
        }
    }

    @FXML
    private void onActionBtnExit(ActionEvent event) {
        cleanComponents();
    }

    @FXML
    private void onActionBtnSave(ActionEvent event) {
        
String routeRoot = System.getProperty("user.dir");
String imagePath = routeRoot + File.separator + "AssociatedPhotographs" + File.separator + associated.getFolio() + ".png";
associated.setAddressPhotography(imagePath);
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
    private void displayAssociatedImage(Associated associated) {
    String userDir = System.getProperty("user.dir");
    String imagePath = userDir + File.separator + "AssociatedPhotographs" + File.separator + associated.getFolio() + ".png";
    
    Path path = Paths.get(imagePath);
    if (Files.exists(path)) {
        Image image = new Image(path.toUri().toString());
        imgUser.setImage(image);
    } else {
        imgUser.setImage(null);
        message.show(Alert.AlertType.WARNING, "Advertencia", "La imagen asociada no está disponible.");
    }
}
  
    
 @Override
    public void initialize() {
    }
}
