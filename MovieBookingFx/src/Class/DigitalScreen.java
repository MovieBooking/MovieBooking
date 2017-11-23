/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author Sivakorn
 */
@MappedSuperclass
public class DigitalScreen extends Screen{

    public DigitalScreen(int id) {
        super(id);
        this.init();
    }

    @Override
    public void init() {
        this.setName("Digital Screen");
        this.setPrice(60);
    }
    
}
