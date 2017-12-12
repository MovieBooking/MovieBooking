/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author terkg
 */
@Entity
public class Report implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String theater;
    private String account;
    private String promotion;
    private String cost;
    private String time;
    private String report=" ";
    public Report(Theater theater,List<Seats> seats,Account account,String cost,Promotion promotion){
        Calendar now = Calendar.getInstance();
        this.time = now.getTime().toString();
        this.theater = "THEATER : "+theater.getTheater_id();
        this.account = "ACCOUNT : "+account.getEmail();
        this.promotion = "PROMOTION : "+promotion.getName()+" : "+promotion.getCode();
        this.cost = cost;
        for (Seats seat : seats) {
            String temp = (String.format("Seat : %-20s Type : %-20s Cost :%-20s \n", seat.getPosition(),seat.getName(),""+(seat.getPrice()+theater.getScreen().getPrice())));
            report = report.concat(temp);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
