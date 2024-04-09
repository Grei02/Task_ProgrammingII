/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.taskprogrammingii.model;

import cr.ac.una.taskprogrammingii.model.Associated;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
    private List <Associated> listAssociated= new ArrayList<>(); 
     
    public void serialization(Associated associated){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listUser.txt"))) {
            listAssociated.add(associated);
            oos.writeObject(listAssociated);
            System.out.println("Objeto serializado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Associated> deserialize(){
         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("listUser.txt"))) {
            listAssociated = (List) ois.readObject();
             System.out.println(listAssociated.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAssociated;
    }
}
