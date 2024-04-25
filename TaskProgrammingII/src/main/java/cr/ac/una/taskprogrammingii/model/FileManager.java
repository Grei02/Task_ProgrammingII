/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.taskprogrammingii.model;

import cr.ac.una.taskprogrammingii.model.Associated;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static java.util.Collections.addAll;
import java.util.List;

public class FileManager<T> {
    
    private String directionFile;
    
    public void serialization(List<T> list, String filename) {
<<<<<<< Updated upstream
     String userDir = System.getProperty("user.dir");
     String destinationPath = userDir + "/FileManager/" + filename;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destinationPath))) {
=======
        directionFile =  System.getProperty("user.dir")+"/" +filename;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(directionFile))) {
>>>>>>> Stashed changes
            oos.writeObject(list); 
            System.out.println("Objeto serializado con éxito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<T> deserialize(String filename) {
        List<T> list = new ArrayList<>();
<<<<<<< Updated upstream
String userDir = System.getProperty("user.dir");
String destinationPath = userDir + "/FileManager/" + filename;


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(destinationPath))) {
=======
        directionFile =  System.getProperty("user.dir")+"/" +filename;
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(directionFile))) {
>>>>>>> Stashed changes
            List<T> deserializedList = (List<T>) ois.readObject();
            list.addAll(deserializedList); 
        } catch (FileNotFoundException e) {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public void serializationRemove(List<T> elementsToRemove, String filename) {
 String userDir = System.getProperty("user.dir");
String destinationPath = userDir + "/FileManager/" + filename;

    List<T> list = deserialize(filename);
    list.removeAll(elementsToRemove);
    
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
        oos.writeObject(list);
        System.out.println("Elemento(s) eliminado(s) con éxito.");
    } catch (IOException e) {
        e.printStackTrace();
    
        }
     }
}

