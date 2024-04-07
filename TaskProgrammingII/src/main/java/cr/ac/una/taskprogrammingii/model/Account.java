/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.taskprogrammingii.model;

public class Account {
    private String type;
    private Integer amount;
    private String logoImage;

    public Account() {
        type = null;
        amount = null;
        logoImage=null;
    }
    
    public Account(String type, Integer amount,String logoImage) {
        this.type = type;
        this.amount = amount;
        this.logoImage=logoImage;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public void setLogoImage(String logoImage){
        this.logoImage=logoImage;
    }

    public String getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }
    public String getLogoImage(){
        return logoImage;
    }
    
}
