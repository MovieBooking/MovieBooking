/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author terkg
 */
@Entity
public class Seats implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private long theater_id;
    private String position;
    private int price;
    private String name;
    private Boolean isBook;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_id")
    private Theater theater;
    
    public Seats(String position,long theater_id){
        this.theater_id = theater_id;
        this.position = position;
        this.isBook = false;
    }
  
    public void init(){
    };

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

    public long getId() {
        return id;
    }

    public long getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(long theater_id) {
        this.theater_id = theater_id;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public String toString() {
        return "Seats{" + "id=" + id + ", theater_id=" + theater_id + ", position=" + position + ", price=" + price + ", name=" + name + ", isBook=" + isBook + '}';
    }
    
    
}
