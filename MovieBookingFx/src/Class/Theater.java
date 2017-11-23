/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int theater_id;

    @OneToOne(mappedBy = "theater", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private Screen screen;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<List<Seats>> seats;
    private String time;
    private String status;

    Theater(Screen screen, String time, int id, String status) {
        this.seats = new ArrayList<List<Seats>>();
        this.theater_id = id;
        this.time = time;
        this.status = status;
        screen.addTheater(this);
    }

    public abstract void init();
    public void addSeats(List<Seats> seats){
        for (Seats seat : seats) {
            seat.setTheater(this);
        }
        this.seats.add(seats);
        
    }
    public void remove(List<Seats> seats){
        for (Seats seat : seats) {
            seat.setTheater(this);
        }
        this.seats.remove(seats);
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

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

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int thearter_id) {
        this.theater_id = thearter_id;
    }

    public List<List<Seats>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Seats>> seats) {
        this.seats = seats;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Theater{" + "id=" + id + ", theater_id=" + theater_id + ", screen=" + screen.toString() + ", time=" + time + ", status=" + status + '}';
    }

}
