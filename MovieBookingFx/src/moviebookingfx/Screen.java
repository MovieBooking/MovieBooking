/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public abstract class Screen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    
    private int theater_id;
    private int price;
    private String name;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    public Screen(int id) {
        this.theater_id = id;
    }

    public abstract void init();

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    
    public Screen getScreen(){
        return this;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
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
        return "Screen{" + "theater_id=" + theater_id + ", price=" + price + ", name=" + name + '}';
    }

}
