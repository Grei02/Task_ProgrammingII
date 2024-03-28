/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.taskprogrammingii.model;

/**
 *
 * @author Sofia Bejarano Mora
 */
public class associated {
    private String name;
    private String Surname;
    private String folio;
    private Integer age;
    
    private associated(){
        name=null;
        Surname=null;
        folio=null;
        age=null;
    }
    private associated(String name,String Surname,String folio,Integer age){
        this.name=name;
        this.Surname=Surname;
        this.folio=folio;
        this.age=age;
    }
    
}
