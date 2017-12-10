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
public class Theater implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int theater_id;

    @OneToOne(mappedBy = "theater", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private Screen screen;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<List<Seats>> seats;
     @OneToOne(mappedBy = "theater", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private Movie movie;
    private String time;
    private String status;
    private String size;
    
    public Theater(String size,Movie movie,Screen screen, String time, int id, String status) {
        this.seats = new ArrayList<List<Seats>>();
        this.theater_id = id;
        this.time = time;
        this.status = status;
        this.size = size;
        if(size.equals("Large"))
            this.createLargeTheater();
        else if (size.equals("Medium"))
            this.createMediumTheater();
        else
            this.createSmallTheater();
        movie.addTheater(this);
        screen.addTheater(this);
        
    }

    public void createLargeTheater() {
        List<Seats> temp2 = new ArrayList<Seats>();
        for (int i = 0; i < 5; i++) {
            temp2.add(new DeluxeSeats("V" + (i + 1), this.getTheater_id()));
        }
        this.addSeats(temp2);
        for (int i = 1; i < 6; i++) {
            temp2 = new ArrayList<Seats>();
            for (int j = 0; j < 20; j++) {
                temp2.add(new HoneymoonSeats(((char) (64 + i)) + "" + (j + 1), this.getTheater_id()));
            }
            this.addSeats(temp2);
        }
        for (int i = 6; i < 16; i++) {
            temp2 = new ArrayList<Seats>();
            for (int j = 0; j < 20; j++) {
                temp2.add(new NormalSeats(((char) (64 + i)) + "" + (j + 1), this.getTheater_id()));
            }
            this.addSeats(temp2);
        }
    }

    public void createSmallTheater() {
        List<Seats> temp2 = new ArrayList<Seats>();
        for (int i = 0; i < 4; i++) {
            temp2.add(new DeluxeSeats("V" + (i + 1), this.getTheater_id()));
        }
        this.addSeats(temp2);
        for (int i = 1; i < 4; i++) {
            temp2 = new ArrayList<Seats>();
            for (int j = 0; j < 15; j++) {
                temp2.add(new HoneymoonSeats(((char) (64 + i)) + "" + (j + 1), this.getTheater_id()));
            }
            this.addSeats(temp2);
        }
        for (int i = 4; i < 11; i++) {
            temp2 = new ArrayList<Seats>();
            for (int j = 0; j < 15; j++) {
                temp2.add(new NormalSeats(((char) (64 + i)) + "" + (j + 1), this.getTheater_id()));
            }
            this.addSeats(temp2);
        }
    }

    public void createMediumTheater() {
        List<Seats> temp2 = new ArrayList<Seats>();
        for (int i = 0; i < 4; i++) {
            temp2.add(new DeluxeSeats("V" + (i + 1), this.getTheater_id()));
        }
        this.addSeats(temp2);
        for (int i = 1; i < 6; i++) {
            temp2 = new ArrayList<Seats>();
            for (int j = 0; j < 15; j++) {
                temp2.add(new HoneymoonSeats(((char) (64 + i)) + "" + (j + 1), this.getTheater_id()));
            }
            this.addSeats(temp2);
        }
        for (int i = 6; i < 16; i++) {
            temp2 = new ArrayList<Seats>();
            for (int j = 0; j < 15; j++) {
                temp2.add(new NormalSeats(((char) (64 + i)) + "" + (j + 1), this.getTheater_id()));
            }
            this.addSeats(temp2);
        }
    }

    public void addSeats(List<Seats> seats) {
        for (Seats seat : seats) {
            seat.setTheater(this);
        }
        this.seats.add(seats);

    }

    public void remove(List<Seats> seats) {
        for (Seats seat : seats) {
            seats.remove(seat);
            seat.setTheater(null);
        }
         
    }
    
    public void removeAll(){
        for (List<Seats> seat : seats) {
            System.out.println("a");
           seats.remove(seat);
        }
        
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
