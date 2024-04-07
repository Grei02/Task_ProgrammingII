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
import javax.imageio.ImageIO;




/**
 * FXML Controller class
 *
 * @author Sofia Bejarano Mora
 */
public class PhotographyController extends Controller implements Initializable {

    private Integer height=200,width=300,counter=0;
    private BufferedImage ruta;
    private  Dimension dimension=new Dimension(height,width);
    private Dimension dimensionResolution=WebcamResolution.VGA.getSize();
    private Webcam webcam=Webcam.getDefault();
    private WebcamPanel webcamPanel= new WebcamPanel(webcam, dimension, false);
    private BufferedImage image;
     Image fxImage;
     
    
    @FXML
    private MFXButton bntTakePhoto;

    @FXML
    private MFXButton btnSavePhoto;

    @FXML
    private ImageView imagenView;
    
   @FXML
    private HBox pnlHbox;

    @FXML
    void onActionBntTakePhoto(ActionEvent event) {

    }

    @FXML
    void onActionBtnSavePhoto(ActionEvent event) {

    }
    public void camera(){
        webcam.open();
        Thread thread=new Thread(){
            public void run(){
                webcamPanel.start();
                image = webcam.getImage();
                 fxImage = SwingFXUtils.toFXImage(image, null);
                 imagenView.setImage(fxImage);
            }
        };
        thread.setDaemon(true);
        thread.start();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @Override
    public void initialize() {
        camera();
    }

}
