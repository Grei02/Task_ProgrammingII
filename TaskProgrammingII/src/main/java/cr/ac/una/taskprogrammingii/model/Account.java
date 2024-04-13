/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.taskprogrammingii.model;

import java.io.Serializable;

public class Account implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String type;
    private Integer amount;
    
    public Account() {
        type = null;
        amount = null;
    }
    
    public Account(String type, Integer amount,String logoImage) {
        this.type = type;
        this.amount = amount;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    public String getType() {
        return type;
    }
    
    public Integer getAmount() {
        return amount;
    }
    
}
