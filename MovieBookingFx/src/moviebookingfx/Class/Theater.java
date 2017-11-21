/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx.Class;

/**
 *
 * @author terkg
 */
public abstract class Theater {
    private Screen screen;
    private Seats[][] seat;
    private String time;
    private int id;
    private String status;
    Theater(String screen,String time,int id,String status){
        this.screen = this.CreateScreen(time);
        this.time = time;
        this.id = id;
        this.status = status;
    }
    public Screen CreateScreen(String screen){
        Screen temp;
        if(screen.equals("IMAX"))
            temp = new ImaxScreen();
        else if (screen.equals("DIGITAL"))
            temp = new DigitalScreen();
        else if (screen.equals("4DX"))
            temp = new FourDimentionScreen();
        else if (screen.equals("ULTRASCREEN"))
            temp = new UltraScreen();
        else 
            temp = new ThreeDimensionScreen();
        return temp;
        
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

    public Seats[][] getSeat() {
        return seat;
    }

    public void setSeat(Seats[][] seat) {
        this.seat = seat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
