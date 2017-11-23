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
public class MovieGRating extends Movie{
    
    public MovieGRating(String name, int length, String genre, String ReleaseDate, String image){
        super(name, length, genre, ReleaseDate, image);
        this.init();
    }

   
    @Override
    public Boolean canBook(int age) {
        return true;
    }

    @Override
    public void init() {
        this.setRate("G");
    }
    
}
