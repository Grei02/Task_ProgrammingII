/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.cooperativaescolar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
    
    private static final long serialVersionUID = 2L;
    
    private String type;
    private Integer amount;
    private List<Transfer> listTransfer; 
    
    public Account() {
        type = null;
        amount = null;
        listTransfer=new ArrayList<>();
    }
    
    public void withdrawaAmountl(Integer amount){
        this.amount-=amount;
    }
    
    public void depositAmount(Integer amount){
        this.amount+=amount;
    }
    
    public Account(String type, Integer amount,List<Transfer> listTransfer) {
        this.type = type;
        this.amount = amount;
        this.listTransfer=listTransfer;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Transfer> getListTransfer() {
        return listTransfer;
    }

    public void setListTransfer(List<Transfer> listTransfer) {
        this.listTransfer = listTransfer;
    }
    
    public String getType() {
        return type;
    }
    
    public Integer getAmount() {
        return amount;
    }
    
}
