/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author terkg
 */
@Entity
public abstract class Seats implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    private long theater_id;
    @GeneratedValue
    private long id;
    private String position;
    private int price;
    private String name;
    private Boolean isBook;
    Seats(String position,long theater_id){
        this.theater_id = theater_id;
        this.position = position;
        this.isBook = false;
    }
  
    public abstract void init();

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getIsBook() {
        return isBook;
    }

    public void setIsBook(Boolean isBook) {
        this.isBook = isBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
