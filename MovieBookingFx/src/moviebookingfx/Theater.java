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
public abstract class Theater implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private int thearter_id;
    @OneToOne
    private Screen screen;
    //@OneToMany
    //private List<List<Seats>> seats;
    private String time;
    
    private String status;
    Theater(String screen,String time,int id,String status){
        this.thearter_id = id;
        this.screen = this.CreateScreen(screen);
        this.time = time;
        this.status = status;
    }
    public Screen CreateScreen(String screen){
        Screen temp;
        if(screen.equals("IMAX"))
            temp = new ImaxScreen(this.thearter_id);
        else if (screen.equals("DIGITAL"))
            temp = new DigitalScreen(this.thearter_id);
        else if (screen.equals("4DX"))
            temp = new FourDimentionScreen(this.thearter_id);
        else if (screen.equals("ULTRASCREEN"))
            temp = new UltraScreen(this.thearter_id);
        else 
            temp = new ThreeDimensionScreen(this.thearter_id);
        System.out.println(screen);
        return temp;
        
    }
    public abstract void init();

    public int getId() {
        return thearter_id;
    }

    public void setId(int id) {
        this.thearter_id = id;
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

    public int getThearter_id() {
        return thearter_id;
    }

    public void setThearter_id(int thearter_id) {
        this.thearter_id = thearter_id;
    }

    public int getSeats() {
        return 0;
        //return seats;
    }

    public int setSeats(List<List<Seats>> seats) {
        return 0;
        //this.seats = seats;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
