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
    private String age;
    
    public associated(){
        name=null;
        lastName=null;
        folio=null;
        age=null;
    }
    public associated(String name,String lastName,String folio,String age){
        this.name=name;
        this.lastName=lastName;
        this.folio=folio;
        this.age=age;
    }
    
    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public String getFolio(){
        return folio;
    }
    public String getAge(){
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    
}
