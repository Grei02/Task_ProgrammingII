/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

<<<<<<< Updated upstream
import cr.ac.una.taskprogrammingii.model.associated;
import cr.ac.una.taskprogrammingii.model.FileManager;
=======
import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.util.FlowController;
>>>>>>> Stashed changes

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


public class registerAssociateSectionViewController implements Initializable {
    
<<<<<<< Updated upstream
     private associated associated=new associated();
     private FileManager fileManager= new FileManager();
=======
     private final Associated associated=new Associated();
>>>>>>> Stashed changes
    
    @FXML
    private TextField txtUserAge;

    @FXML
    private TextField txtUserLastName;

    private TextField txtuserName;
    
    @FXML
    private Button btnSave;;
    @FXML
    private Button btnCancel;
    
    @FXML
    void onActionbtnSave(ActionEvent event) {
        associated.setName(txtuserName.getText());
        associated.setLastName(txtUserLastName.getText());
        associated.setAge(txtUserAge.getText());
        
         if (!associated.getName().isBlank() && !associated.getLastName().isBlank() && !associated.getAge().isBlank()) {
<<<<<<< Updated upstream
             fileManager.serialization(associated);
             fileManager.deserialize().get(0).imprimir();
             //saveToFile(associated);
=======
             
              saveToFile(associated);
              System.out.println("Guardado con exito");
>>>>>>> Stashed changes
        }
        else{
            // ((Stage)btnSave.getScene().getWindow()).close();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
<<<<<<< Updated upstream
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
=======
    }    
    private void saveToFile(Associated associated) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estudiantes_asociados.txt", true))) {
            writer.write("Nombre: " + associated.getName());
            writer.newLine();
            writer.write("Apellido: " + associated.getLastName());
            writer.newLine();
            writer.write("Edad: " + associated.getAge());
            writer.newLine();
            writer.write("--------------------");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
>>>>>>> Stashed changes
    }

    @FXML
    private void onActionBtnCancel(ActionEvent event) {
     FlowController.getInstance().goView("startAssociateSectionView");
    Stage stage = (Stage) btnCancel.getScene().getWindow();
    stage.close();
    }

}
