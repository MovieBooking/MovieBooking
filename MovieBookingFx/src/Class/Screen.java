/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Screen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int theater_id;
    private int price;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Theater> theater;

    public Screen(String name, int id) {
        if (name.equals("3D")) {
            this.create3dscreen();
        } else if (name.equals("Ultra")) {
            this.createultrascreen();
        } else if (name.equals("Imax")) {
            this.createimaxscreen();
        } else if (name.equals("4D")) {
            this.create4dxscreen();
        } else {
            this.createdigitalscreen();
        }
        this.theater = new ArrayList<Theater>();
        this.theater_id = id;
    }

    public void createdigitalscreen() {
        this.setName("Digital Screen");
        this.setPrice(40);
    }

    public void create4dxscreen() {
        this.setName("4DX Screen");
        this.setPrice(150);
    }

    public void createimaxscreen() {
        this.setName("Imax Screen");
        this.setPrice(80);
    }

    public void create3dscreen() {
        this.setName("3D Screen");
        this.setPrice(50);
    }

    public void createultrascreen() {
        this.setName("Ultra Screen");
        this.setPrice(100);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Screen getScreen() {
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

    @Override
    public String toString() {
        return "Screen{" + "theater_id=" + theater_id + ", price=" + price + ", name=" + name + '}';
    }

    public List<Theater> getTheater() {
        return theater;
    }

    public void setTheater(List<Theater> theater) {
        this.theater = theater;
    }

    public void addTheater(Theater theater) {
        theater.setScreen(this);
        this.theater.add(theater);

    }

    public void removeTheater(Theater theater) {
        this.theater.remove(theater);
        theater.setScreen(null);
    }
    
    
}
