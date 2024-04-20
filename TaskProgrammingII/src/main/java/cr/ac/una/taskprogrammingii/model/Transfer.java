/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.taskprogrammingii.model;

import java.io.Serializable;

public class Transfer implements Serializable{
    
    private static final long serialVersionUID = 3L;
    
    private String Type;
    private String amount;

    public Transfer(String Type, String amount) {
        this.Type = Type;
        this.amount = amount;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return Type;
    }

    public String getAmount() {
        return amount;
    }
    
}
