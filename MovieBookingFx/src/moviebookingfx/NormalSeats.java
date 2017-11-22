/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author terkg
 */
@MappedSuperclass
public class NormalSeats extends Seats{

    public NormalSeats(String position, long theater_id) {
        super(position, theater_id);
        this.init();
    }

    @Override
    public void init() {
        this.setName("Normal Seat");
        this.setPrice(100);
    }
    
}
