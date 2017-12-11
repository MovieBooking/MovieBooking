/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Sivakorn
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private long id;
    private String dateOfBirth;
    private String email;
    private int point;
    private String firstname;
    private String lastname;
    private String member = "Normal Member";
    private String phonenumber;

    public Account(String dateOfBirth, String email, String firstname, String lastname,String phonenumber) {
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.point = 0;
        this.phonenumber = phonenumber;
    }
    
    public void setToGoldMember(){
        this.member = "Gold Member";
    }
    public void setToPatinumMember(){
        this.member = "Patinum Member";
    }
    public void setToDiamonMember(){
        this.member = "Diamon Member";
    }
    public void setToNormalMember(){
        this.member = "Normal Member";
    }
   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public int getPoint() {
        return point;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
