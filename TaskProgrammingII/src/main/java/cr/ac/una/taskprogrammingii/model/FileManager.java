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


public class FileManager <T> {
    //private List <T> list= new ArrayList<>(); 
     
    public void serialization(/*T object, String filename*/List <T> list){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
            System.out.println("Objeto serializado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
//            deserialize(filename);
//             list.add(object );
//            oos.writeObject(list);
//            System.out.println("Objeto serializado con éxito.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    
    public List<T> deserialize(String filename) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
        list = (List<T>) ois.readObject();
         System.out.println(list.get(0));
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

}
