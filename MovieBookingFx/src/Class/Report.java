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
    private float cost=0;
    private String time;
    private String report="";
    public Report(Theater theater,List<Seats> seats,Account account,String cost,Promotion promotion){
        Calendar now = Calendar.getInstance();
        this.time = now.getTime().toString();
        this.theater = "THEATER : "+theater.getTheater_id();
        this.account = "ACCOUNT : "+account.getEmail();
        this.promotion = "PROMOTION : "+promotion.getName()+" : "+promotion.getCode();
        for (Seats seat : seats) {
            report.concat(String.format("Seat : %20s Cost :%20s \n", seat.getName(),""+(seat.getPrice()+theater.getScreen().getPrice())));
            this.cost += theater.getScreen().getPrice()+seat.getPrice();
        }
        this.cost=this.cost*(100+promotion.getDiscount()+account.getDiscount());
        
        report.concat(String.format("Total %f",cost));
    }
}
