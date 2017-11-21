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
public class SmallTheater extends Theater {

    public SmallTheater(String screen, String time, int id, String status) {
        super(screen, time, id, status);
        init();
    }

    @Override
    public void init() {
        Seats temp[][] = new Seats[11][15];
        for (int i = 0; i < 4; i++) {
            temp[0][i] = new DeluxeSeats("VIP-" + (i + 1));
        }
        for (int i = 4; i < 15; i++) {
            temp[0][i] = new DeluxeSeats("Don't Use");
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 15; j++) {
                temp[i][j] = new HoneymoonSeats(((char) (64 + i)) + "" + (j + 1));
            }
        }
        for (int i = 4; i < 11; i++) {
            for (int j = 0; j < 15; j++) {
                temp[i][j] = new NormalSeats(((char) (64 + i)) + "" + (j + 1));
            }
        }
        this.setSeat(temp);
    }

}
