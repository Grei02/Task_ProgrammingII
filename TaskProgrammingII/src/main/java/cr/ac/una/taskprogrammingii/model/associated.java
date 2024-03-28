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
    private String lastName;
    private String folio;
    private Integer age;
    
    private associated(){
        name=null;
        lastName=null;
        folio=null;
        age=null;
    }
    private associated(String name,String lastName,String folio,Integer age){
        this.name=name;
        this.lastName=lastName;
        this.folio=folio;
        this.age=age;
    }
    
}
