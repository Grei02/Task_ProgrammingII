/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.util.FlowController;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import cr.ac.una.taskprogrammingii.util.AppContext;
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

public class PhotographyController extends Controller implements Initializable {

    Image imageTakePhoto;
    Image image;
    Boolean checkedCamera=true;
    private Mensaje message=new Mensaje();
    private BufferedImage bufferedImage;
    private  Dimension dimension=new Dimension(200,300);
    private Webcam webcam=Webcam.getDefault();
    private WebcamPanel webcamPanel= new WebcamPanel(webcam, dimension, false);
    private Thread thread;
    
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
           AppContext.getInstance().set("bufferedImageAssociated", bufferedImage);
           close();
           ((Stage)btnSavePhoto.getScene().getWindow()).close();
        }
        else{
            message.show(Alert.AlertType.INFORMATION, "Aviso", "No se a registrado tu foto");
        }
    }
    
    public void close(){
           webcamPanel.stop();
           webcam.close();
           imvPhotography.setImage(null);
           imageTakePhoto=null;
           bufferedImage=null;
    }
    
    public void camera(){
        webcam.open();
        webcamPanel.start();
         thread=new Thread(){
            @Override
            public void run(){
                webcamPanel.start();
                while (checkedCamera){
                bufferedImage = webcam.getImage();
                 image = SwingFXUtils.toFXImage(bufferedImage, null);
                 imvCamera.setImage(image);
                 try{
                 Thread.sleep(10);
                }
                 catch (InterruptedException e){
                      System.out.println("Error:"+e);
                  }
              }
            }
        };
        if(checkedCamera){
        thread.start();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @Override
    public void initialize() {
       camera();
       
        imvBackgroundImage.fitHeightProperty().bind(root.heightProperty());
        imvBackgroundImage.fitWidthProperty().bind(root.widthProperty());
    }
}
