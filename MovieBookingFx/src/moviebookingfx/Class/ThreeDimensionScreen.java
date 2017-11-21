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
public class ThreeDimensionScreen extends Screen{
    public ThreeDimensionScreen(){
        super();
        this.init();
    }
    @Override
    public void init() {
        this.setName("3D Screen");
        this.setPrice(80);
    }
    
}
