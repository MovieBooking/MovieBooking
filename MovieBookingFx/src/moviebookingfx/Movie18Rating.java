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
public class Movie18Rating extends Movie {

    public Movie18Rating(String name, int length, String genre, String ReleaseDate, String image){
        super(name, length, genre, ReleaseDate, image);
        this.init();
    }

    
    @Override
    public Boolean canBook(int age) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init() {
        this.setRate("18+");
    }
    
}