/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javafx.scene.image.Image;

/**
 *
 * @author terkg
 */
@Entity
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int length;
    private String genre;
    private String ReleaseDate;
    private int rate = 100;
    private String ratename = "General";
    private String image;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Theater> theater;
    private String language;
    public Movie(String name, int length, String genre, String ReleaseDate, String image, int rate,String language) {
        this.language = language;
        this.theater = new ArrayList<Theater>();
        this.name = name;
        this.length = length;
        this.genre = genre;
        this.ReleaseDate = ReleaseDate;
        this.image = image;
        if (rate != 0) {
            this.rate = rate;
            this.ratename = "" + rate + "+";
        }
    }

    public Boolean canBook(int age) {
        if (age <= this.rate) {
            return false;
        } else {
            return true;
        }
    }

    public Image showImage() {
        return new Image(this.image, 50, 50, true, true);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String showLength() {
        int Hour = this.length / 60;
        int Min = this.length % 60;
        if (Min > 9) {
            return ("" + Hour + ":" + Min);
        } else {
            return ("" + Hour + ":0" + Min);
        }
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getRatename() {
        return ratename;
    }

    public void setRatename(String ratename) {
        this.ratename = ratename;
    }

     public void addTheater(Theater theater) {
        theater.setMovie(this);
        this.theater.add(theater);

    }

    public void removeTheater(Theater theater) {
        this.theater.remove(theater);
        theater.setMovie(null);
    }
}
