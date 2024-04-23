/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.taskprogrammingii.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Associated implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String lastName;
    private String secondLastName;
    private String folio;
    private String age;
    private String addressPhotography;
    private List<Account> acountList=new ArrayList<>();
    
    public Associated(){
        name=null;
        lastName=null;
        secondLastName=null;
        folio=null;
        age=null;
        addressPhotography=null;
        acountList=null;
    }
    
    public Associated(String name,String lastName,String secondLastName,String folio,String age){
        this.name=name;
        this.lastName=lastName;
        this.secondLastName=secondLastName;
        this.folio=folio;
        this.age=age;
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

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
     public void setAddressPhotography(String addressPhotography) {
       this.addressPhotography = addressPhotography;
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
    public String getAddressPhotography() {
        return System.getProperty("user.dir")+addressPhotography;
    }

    public List<Account> getAcountList() {
        return acountList;
    }

    public void setAcountList(List<Account> acountList) {
        this.acountList = acountList;
    }
    
    public void addAccount(Account account) {
    if (account != null) {
        acountList.add(account);
        System.out.println("Cuenta agregada correctamente: " + account.getType());
        System.out.println("Lista de cuentas asociadas actualizada: " + acountList);
    }
}
    public void removeAccount(Account account) {
    if (account != null) {
        acountList.remove(account);
    }
}

}
