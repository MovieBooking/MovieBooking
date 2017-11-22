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
public class Movie15Rating extends Movie {

    public Movie15Rating(String name, int length, String genre, String ReleaseDate, String image) {
        super(name, length, genre, ReleaseDate, image);
        this.init();
    }

    @Override
    public Boolean canBook(int age) {
        if (age <= 15) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void init() {
        this.setRate("15+");
    }

}
