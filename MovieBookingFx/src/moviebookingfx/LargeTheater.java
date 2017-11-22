/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author terkg
 */
@MappedSuperclass
public class LargeTheater extends Theater {

    public LargeTheater(Screen screen, String time, int id, String status) {
        super(screen, time, id, status);
    }
   
     @Override
    public void init() {
        Seats temp[][] = new Seats[16][20];
        for (int i = 0; i < 5; i++) {
            temp[0][i] = new DeluxeSeats("VIP-" + (i + 1),this.getId());
        }
        for (int i = 4; i < 15; i++) {
            temp[0][i] = new DeluxeSeats("Don't Use",this.getId());
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                temp[i][j] = new HoneymoonSeats(((char) (64 + i)) + "" + (j + 1),this.getId());
            }
        }
        for (int i = 6; i < 16; i++) {
            for (int j = 0; j < 20; j++) {
                temp[i][j] = new NormalSeats(((char) (64 + i)) + "" + (j + 1),this.getId());
            }
        }
        this.setSeats(temp);
    }

}
