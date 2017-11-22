/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author terkg
 */
@Entity
public abstract class Theater implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private int theater_id;
    @Transient
    private Screen screen;
    @Transient
    private Seats[][] seats;
    @Column
    private String time;

    private String status;

    Theater(Screen screen, String time, int id, String status) {
        this.theater_id = id;
        this.time = time;
        this.status = status;
        this.screen = screen;
    }

    public abstract void init();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int thearter_id) {
        this.theater_id = thearter_id;
    }

    public Seats[][] getSeats() {
        return seats;
    }

    public void setSeats(Seats[][] seats) {
        this.seats = seats;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
