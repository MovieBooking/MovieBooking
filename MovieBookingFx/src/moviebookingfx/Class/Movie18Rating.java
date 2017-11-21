/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx.Class;

import javafx.scene.image.Image;

/**
 *
 * @author terkg
 */
public class Movie18Rating extends Movie {

    public Movie18Rating(String name, int length, String genre, String ReleaseDate, String rate, Image image) {
        super(name, length, genre, ReleaseDate, rate, image);
    }

    
    @Override
    public Boolean canBook(int age) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}