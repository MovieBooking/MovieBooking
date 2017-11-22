/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author terkg
 */
@MappedSuperclass
public class SmallTheater extends Theater {

    public SmallTheater(Screen screen, String time, int id, String status) {
        super(screen, time, id, status);
        this.init();
    }

    @Override
    public void init() {
        List<Seats> temp2 = new ArrayList<Seats>();
        for (int i = 0; i < 4; i++) {
            temp2.add(new DeluxeSeats("VIP-" + (i + 1), this.getTheater_id()));
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

}
