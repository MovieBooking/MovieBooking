/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author terkg
 */
@MappedSuperclass
public class MediumTheater extends Theater {

    public MediumTheater(Screen screen, String time, int id, String status) {
        super(screen, time, id, status);
        this.init();
    }

    @Override
    public void init() {
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
}
