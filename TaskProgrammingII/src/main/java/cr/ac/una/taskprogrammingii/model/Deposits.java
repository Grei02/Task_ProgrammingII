/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.taskprogrammingii.model;

import cr.ac.una.taskprogrammingii.model.Associated;
import java.util.logging.Logger;

public class Deposits {
    private Associated associated;
    private Integer coin5;
    private Integer coin10;
    private Integer coin25;
    private Integer coin50;
    private Integer coin100;
    private Integer coin500;
    private Integer Bill1000;
    private Integer Bill2000;
    private Integer Bill5000;
    private Integer Bill10000;
    private Integer Bill20000;
    private Integer Total;
    private static final Logger LOG = Logger.getLogger(Deposits.class.getName());
    
    public Deposits(){
        associated=null;
        coin5 = null;
        coin10 = null;
        coin25 = null;
        coin50 = null;
        coin100 = null;
        coin500 = null;
        Bill1000 = null;
        Bill2000 = null;
        Bill5000 = null;
        Bill10000 = null;
        Bill20000 = null;
        Total = null;
    }

    public Deposits(Associated associated, Integer coin5, Integer coin10, Integer coin25, Integer coin50, Integer coin100, Integer coin500, Integer Bill1000, Integer Bill2000, Integer Bill5000, Integer Bill10000, Integer Bill20000, Integer Total) {
        this.associated = associated;
        this.coin5 = coin5;
        this.coin10 = coin10;
        this.coin25 = coin25;
        this.coin50 = coin50;
        this.coin100 = coin100;
        this.coin500 = coin500;
        this.Bill1000 = Bill1000;
        this.Bill2000 = Bill2000;
        this.Bill5000 = Bill5000;
        this.Bill10000 = Bill10000;
        this.Bill20000 = Bill20000;
        this.Total = Total;
    }

    public Associated getAssociated() {
        return associated;
    }

    public void setAssociated(Associated associated) {
        this.associated = associated;
    }

    public Integer getCoin5() {
        return coin5;
    }

    public void setCoin5(Integer coin5) {
        this.coin5 = coin5;
    }

    public Integer getCoin10() {
        return coin10;
    }

    public void setCoin10(Integer coin10) {
        this.coin10 = coin10;
    }

    public Integer getCoin25() {
        return coin25;
    }

    public void setCoin25(Integer coin25) {
        this.coin25 = coin25;
    }

    public Integer getCoin50() {
        return coin50;
    }

    public void setCoin50(Integer coin50) {
        this.coin50 = coin50;
    }

    public Integer getCoin100() {
        return coin100;
    }

    public void setCoin100(Integer coin100) {
        this.coin100 = coin100;
    }

    public Integer getCoin500() {
        return coin500;
    }

    public void setCoin500(Integer coin500) {
        this.coin500 = coin500;
    }

    public Integer getBill1000() {
        return Bill1000;
    }

    public void setBill1000(Integer Bill1000) {
        this.Bill1000 = Bill1000;
    }

    public Integer getBill2000() {
        return Bill2000;
    }

    public void setBill2000(Integer Bill2000) {
        this.Bill2000 = Bill2000;
    }

    public Integer getBill5000() {
        return Bill5000;
    }

    public void setBill5000(Integer Bill5000) {
        this.Bill5000 = Bill5000;
    }

    public Integer getBill10000() {
        return Bill10000;
    }

    public void setBill10000(Integer Bill10000) {
        this.Bill10000 = Bill10000;
    }

    public Integer getBill20000() {
        return Bill20000;
    }

    public void setBill20000(Integer Bill20000) {
        this.Bill20000 = Bill20000;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer Total) {
        this.Total = Total;
    }
   
    public void calculateTotal(){
        Integer amountCoin;
        Integer amountBill;
        amountCoin=(coin5*5)+(coin10*10)+(coin25*25)+(coin50*50)+(coin100*100)+(coin500*500);
        amountBill=(Bill1000*1000)+(Bill2000*2000)+(Bill5000*5000)+(Bill10000*10000)+(Bill20000*20000);
        Total=amountCoin+amountBill;
    }
}
