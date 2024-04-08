/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.util.FlowController;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.utils.SwingFXUtils;
import java.awt.Dimension;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;




/**
 * FXML Controller class
 *
 * @author Sofia Bejarano Mora
 */
public class PhotographyController extends Controller implements Initializable {

    private Integer height=200,width=300,counter=0;
    Boolean checkedCamara=true;
    private BufferedImage ruta;
    private  Dimension dimension=new Dimension(height,width);
    private Dimension dimensionResolution=WebcamResolution.VGA.getSize();
    private Webcam webcam=Webcam.getDefault();
    private WebcamPanel webcamPanel= new WebcamPanel(webcam, dimension, false);
    private BufferedImage bufferedImage;
    Image image;
     
    
    @FXML
    private MFXButton bntTakePhoto;

    @FXML
    private MFXButton btnSavePhoto;

    @FXML
    private ImageView imvCamera;

    @FXML
    private ImageView imvPhotography;

    @FXML
    void onActionBntTakePhoto(ActionEvent event) {
        image = SwingFXUtils.toFXImage(bufferedImage, null);
        imvPhotography.setImage(image);
    }

    @FXML
    void onActionBtnSavePhoto(ActionEvent event) {
        savePhoto();
        webcamPanel.stop();
        webcam.close();
        ((Stage) btnSavePhoto.getScene().getWindow()).close();
       
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
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
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
        camera();
    }    

    @Override
    public void initialize() {
        
    }

}
