/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;




/**
 * FXML Controller class
 *
 * @author Sofia Bejarano Mora
 */
public class PhotographyController implements Initializable {
    
    
    public void camera(){
        Webcam sdfsed= Webcam.getDefault();
        sdfsed.open();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
}
