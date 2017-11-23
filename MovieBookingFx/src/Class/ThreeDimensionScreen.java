/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author terkg
 */
@MappedSuperclass
public class ThreeDimensionScreen extends Screen{

    public ThreeDimensionScreen(int id) {
        super(id);
        this.init();
    }

    @Override
    public void init() {
        this.setName("3D Screen");
        this.setPrice(80);
    }
    
}
