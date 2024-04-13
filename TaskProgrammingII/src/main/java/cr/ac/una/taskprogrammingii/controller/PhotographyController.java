/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.util.Mensaje;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.utils.SwingFXUtils;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;




/**
 * FXML Controller class
 *
 * @author Sofia Bejarano Mora
 */
public class PhotographyController extends Controller implements Initializable {

    Image imageTakePhoto;
    Image image;
    Boolean checkedCamara=true;
    private Mensaje message=new Mensaje();
    private BufferedImage bufferedImage;
    private  Dimension dimension=new Dimension(200,300);
    private Webcam webcam=Webcam.getDefault();
    private WebcamPanel webcamPanel= new WebcamPanel(webcam, dimension, false);
    
    @FXML
    private MFXButton bntTakePhoto;

    @FXML
    private MFXButton btnSavePhoto;

    @FXML
    private ImageView imvCamera;

    @FXML
    private ImageView imvBackgroundImage;
    
    @FXML
    private ImageView imvPhotography;
    
    @FXML
    private AnchorPane root;

    @FXML
    void onActionBntTakePhoto(ActionEvent event) {
        imageTakePhoto = SwingFXUtils.toFXImage(bufferedImage, null);
        imvPhotography.setImage(imageTakePhoto);
    }

    @FXML
    void onActionBtnSavePhoto(ActionEvent event) {
        if(imageTakePhoto!=null){
            savePhoto();
            webcamPanel.stop();
            webcam.close();
            ((Stage) btnSavePhoto.getScene().getWindow()).close();
        }
        else{
            message.show(Alert.AlertType.INFORMATION, "Aviso", "No se a registrado tu foto");
        }
    }
    
    public void camera(){
        webcam.open();
        Thread thread=new Thread(){
            public void run(){
                webcamPanel.start();
                while (checkedCamara){
                bufferedImage = webcam.getImage();
                 image = SwingFXUtils.toFXImage(bufferedImage, null);
                 imvCamera.setImage(image);
                 try{
                 Thread.sleep(7);
                }
                 catch (Exception e){
                      System.out.println("Error:"+e);
                  }
                }
            }
        };
        if(checkedCamara){
        thread.start();
        }
    }
    
    public void savePhoto(){
     String rutaRaiz = System.getProperty("user.dir");
     File savePhoto = new File(rutaRaiz+"\\FotosAsociados\\foto.png");
      try {
          ImageIO.write(bufferedImage, "png", savePhoto);
      }
      catch (Exception e){
          System.out.println("Error:"+e);
      }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         imvBackgroundImage.fitHeightProperty().bind(root.heightProperty());
        imvBackgroundImage.fitWidthProperty().bind(root.widthProperty());
        camera();
    }    

    @Override
    public void initialize() {
        
    }

}
