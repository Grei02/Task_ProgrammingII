/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.util.FlowController;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import io.github.palexdev.materialfx.utils.SwingFXUtils;
import java.awt.image.BufferedImage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class registerAssociateSectionController extends Controller implements Initializable {
    
     private Associated associated=new Associated();
     private FileManager fileManager= new FileManager();
     private Mensaje message=new Mensaje();
     private List<Associated> associatedList=new ArrayList<>();
     
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
    private TextField txtUserFolio;
    
    @FXML
    private TextField labFolio;

    @FXML
    void onActionBtnTakePhoto(ActionEvent event) {
        associated.setName(txtuserName.getText().trim());
        associated.setLastName(txtUserLastName.getText().trim());
        associated.setAge(txtUserAge.getText().trim());
        
        if (!associated.getName().isBlank() && !associated.getLastName().isBlank() && !associated.getAge().isBlank()) {
            createFolio();
            FlowController.getInstance().goViewInWindow("PhotographyView");
        }
        else{
            message.show(Alert.AlertType.WARNING, "Alerta", "Has dejado un espacio en blanco, por favor llenalo o no podras registarte.");
        } 
      
    }
    
    @FXML
    void onActionbtnSave(ActionEvent event) {
         if (FlowController.getInstance().getBufferedImage()!=null) {
             savePhoto();
             FlowController.getInstance().setBufferedImage(null);
             fileManager.serializationAdd(associated,"ListAssociated.txt");
             message.show(Alert.AlertType.INFORMATION, "Confirmacion", "Te has registrado existosamente");
             txtuserName.setText(null);
             txtUserLastName.setText(null);
             txtUserAge.setText(null);
        }
        else{
            message.show(Alert.AlertType.WARNING, "Alerta", "Para guardar debes tomarte una foto.");
        }
    }
    
    private void createFolio() {
        if(associated.getFolio()==null){
        String folio=null;
        Random random=new Random();
        char letter=associated.getLastName().charAt(0);
        do{
           folio=Character.toUpperCase(letter)+String.valueOf(random.nextInt(401) + 99);
        } while (existsFolio(folio));
        associated.setFolio(folio);
        }
    }
    
    private Boolean existsFolio(String folio){
        associatedList=fileManager.deserialize("ListAssociated.txt");
        for(Associated compareAssociated:associatedList){
            if(compareAssociated.getFolio()==folio){
                return true;
            }
        }
        return false;
    }
    
    public void savePhoto(){
     String routeRoot = System.getProperty("user.dir");
     String  dirección="\\AssociatedPhotographs\\"+associated.getFolio()+".png";
     File savePhoto = new File(routeRoot+dirección);
     associated.setAddressPhotography(dirección);
      try {
          ImageIO.write(FlowController.getInstance().getBufferedImage(), "png", savePhoto);
      }
      catch (Exception e){
          System.out.println("Error:"+e);
      }
    }
    
    public void showPhoto(){
         if(FlowController.getInstance().getBufferedImage()!=null){
            BufferedImage bufferedImage=FlowController.getInstance().getBufferedImage();
             Image userImage= SwingFXUtils.toFXImage(bufferedImage, null);
             imvUserImage.setImage(userImage);
            }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       associatedList=fileManager.deserialize("ListAssociated.txt");
//       txtuserName.setText(associatedList.get(2).getName());
//       txtUserLastName.setText(associatedList.get(2).getLastName());
//       txtUserAge.setText(associatedList.get(2).getAge());
//        System.out.println(associatedList.get(2).getFolio());
//        Image userImage= new Image("file:///"+associatedList.get(2).getAddressPhotography());
//        imvUserImage.setImage(userImage);
    }

    @Override
    public void initialize() {
        showPhoto();
    }

}
