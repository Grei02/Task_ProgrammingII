
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;


public class editUserController extends Controller  implements Initializable {

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
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtSecondLastName;
    @FXML
    private TextField txtName;
    
   Mensaje message = new Mensaje();
   FileManager fileManager= new FileManager(); 
   Associated associated = new Associated();
   List<Associated> associatedList=null;
    Boolean isFoil=false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        enableComponent(true);
        cleanComponent();
    }    
    
    public void cleanComponent(){
        txtFoil.clear();
        imgUser.setImage(null);
        txtAge.setText(null);
        txtName.setText(null);
        txtLastName.setText(null);
        txtSecondLastName.setText(null);
    }

    @FXML
    private void onActionBtnSearch(ActionEvent event) {
              
        if (findAssociateByFolio()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("Asociado encontrado por folio:");
            alert.setContentText("Nombre: " + associated.getName() + " " + associated.getLastName()+ " " + associated.getSecondLastName() + "\n¿Deseas desplegar las cuentas de este asociado?");
            txtName.setText(associated.getName());
            txtLastName.setText(associated.getLastName());
            txtSecondLastName.setText(associated.getSecondLastName());
            txtAge.setText(associated.getAge());
            enableComponent(false);
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                displayAssociatedImage(associated);
                isFoil=true;
            }
        } 
        else {
                    message.show(Alert.AlertType.ERROR, "Error", "No se encontró ningún asociado con el número de folio proporcionado.");
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
        enableComponent(true);
        cleanComponent();
    }

    @FXML
    private void onActionBtnSave(ActionEvent event) {
        if(checkUserDataEmpty()){
            obtainUserData();
            String routeRoot = System.getProperty("user.dir");
            String imagePath = routeRoot + File.separator + "AssociatedPhotographs" + File.separator + associated.getFolio() + ".png";
            associated.setAddressPhotography(imagePath);
            fileManager.serialization(associatedList, "ListAssociated.txt");
            enableComponent(true);
            cleanComponent();
            }
        else if(!txtAge.getText().matches("[0-9]+")){
            message.show(Alert.AlertType.WARNING, "Error","En la edad solo se permiten numeros.");
        }
        else{
            message.show(Alert.AlertType.WARNING, "Advertencia", "Recuerda que solo el nombre puede llevar dos palabras, no se permiten los espacios al inicio o al final y sobre todo revisa no haber dejado ningun espacio en blanco");
        }
     }
    
    public Boolean checkUserDataEmpty(){
        String expresionRegular = "^[a-zA-Z]+$";
        if(txtAge.getText().matches("[0-9]+") && txtLastName.getText().matches(expresionRegular) && txtName.getText().matches("^[a-zA-Z]+(\\s[a-zA-Z]+)*$") &&
                txtSecondLastName.getText().matches(expresionRegular)){
            return true;
        }
        return false;
    }
    
    public void obtainUserData(){
        associated.setName(txtName.getText());
        associated.setLastName(txtLastName.getText());
        associated.setSecondLastName(txtSecondLastName.getText());
        associated.setAge(txtAge.getText());
    }

    private Boolean findAssociateByFolio( ) {
    associatedList = fileManager.deserialize("ListAssociated.txt");
    if(txtFoil.getText()!=null && !txtFoil.getText().isEmpty())
        for (Associated associatedCompare : associatedList) {
            if (txtFoil.getText().trim().toUpperCase().equals(associatedCompare.getFolio())) {
                 associated=associatedCompare;
                 return true;
            }
        }
    return false;
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
    
    public void enableComponent(Boolean anable){
        txtFoil.setDisable(!anable);
        btnSearch.setDisable(!anable);
        txtAge.setDisable(anable);
        txtName.setDisable(anable);
        txtLastName.setDisable(anable);
        txtSecondLastName.setDisable(anable);
        btnSave.setDisable(anable);
    }
    
 @Override
    public void initialize() {
        enableComponent(true);
    }
    
}
