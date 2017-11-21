/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx.Class;


public class DigitalScreen extends Screen{

    public DigitalScreen() {
        super();
        this.init();
    }

    @Override
    public void init() {
        this.setName("Digital Screen");
        this.setPrice(60);
    }
    
}
