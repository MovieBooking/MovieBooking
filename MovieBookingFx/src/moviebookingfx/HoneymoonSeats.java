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
public class HoneymoonSeats extends Seats{

    public HoneymoonSeats(String position, long theater_id) {
        super(position, theater_id);
        this.init();
    }

  

    @Override
    public void init() {
        this.setName("Honeymoon Seat");
        this.setPrice(120);
    }
    
}
