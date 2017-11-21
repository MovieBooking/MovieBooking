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
public abstract class Movie {
    private String name;
    private int length;
    private String genre;
    private String ReleaseDate;
    private String rate;
    private Image image;
    
    Movie(String name,int length,String genre,String ReleaseDate,String rate,Image image){
        this.name = name;
        this.length = length;
        this.genre = genre;
        this.ReleaseDate = ReleaseDate;
        this.rate = rate;
        this.image = image;
    }
    
    public abstract Boolean canBook(int age);
    
    public String showLength(){
        int Hour = this.length/60;
        int Min = this.length%60;
        if(Min>9)
        return (""+ Hour +":"+ Min);
        else
        return (""+Hour+":0"+Min);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
    
}
