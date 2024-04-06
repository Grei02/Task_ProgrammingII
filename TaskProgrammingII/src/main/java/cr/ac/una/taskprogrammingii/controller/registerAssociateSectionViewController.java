/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.util.Mensaje;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class registerAssociateSectionViewController extends Controller implements Initializable {
    
     private Associated associated=new Associated();
     private FileManager fileManager= new FileManager();
    private Mensaje mensaje=new Mensaje();
    @FXML
    private TextField txtUserAge;

    @FXML
    private TextField txtUserLastName;

    @FXML
    private TextField txtuserName;
    
    @FXML
    private Button btnSave;;
    
    @FXML
    void onActionbtnSave(ActionEvent event) {
        associated.setName(txtuserName.getText());
        associated.setLastName(txtUserLastName.getText());
        associated.setAge(txtUserAge.getText());
        
         if (!associated.getName().isBlank() && !associated.getLastName().isBlank() && !associated.getAge().isBlank()) {
             fileManager.serialization(associated);
             fileManager.deserialize().get(0).imprimir();
          //   mensaje.showConfirmation(titulo, "registerAssociateSectionView", mensaje);
        }
        else{
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
//    }    
//    private void saveToFile(associated associated) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estudiantes_asociados.txt", true))) {
//            writer.write("Nombre: " + associated.getName());
//            writer.newLine();
//            writer.write("Apellido: " + associated.getLastName());
//            writer.newLine();
//            writer.write("Edad: " + associated.getAge());
//            writer.newLine();
//            writer.write("--------------------");
//            writer.newLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void initialize() {

    }

}
