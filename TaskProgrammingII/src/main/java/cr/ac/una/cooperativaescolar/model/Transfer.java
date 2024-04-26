/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.cooperativaescolar.model;

import java.io.Serializable;

public class Transfer implements Serializable{
    
    private static final long serialVersionUID = 3L;
    
    private String type;
    private String amount;

    public Transfer(String type, String amount) {
        this.type = type;
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getAmount() {
        return amount;
    }
    
}
