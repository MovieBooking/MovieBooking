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
public abstract class Account {
    @Id @GeneratedValue
    private long id;
    private int age;
    private String dateOfBirth;
    private String email;
    private int point;
    private String firstname;
    private String lastname;

    Account(String dateOfBirth, String email, String firstname, String lastname) {
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.point = 0;
        this.age = findAge();
    }

    public int getAge() {
        return age;
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

    public void setAge(int age) {
        this.age = age;
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
    
    public void updateAge()
    {
        this.age = findAge();
    }
    
    public abstract int discount();
    {
        
    }
    public int findAge() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String now = formatter.format(date);
        String dayn = now.substring(0, 2);
        String monthn = now.substring(3, 5);
        String yearn = now.substring(6, 10);
        int age;
        int resultdayn = Integer.parseInt(dayn);
        int resultmonthn = Integer.parseInt(monthn);
        int resultyearn = Integer.parseInt(yearn)-543;
        String day = this.dateOfBirth.substring(0, 2);
        String month = this.dateOfBirth.substring(3, 5);
        String year = this.dateOfBirth.substring(6, 10);
        int resultday = Integer.parseInt(day);
        int resultmonth = Integer.parseInt(month);
        int resultyear = Integer.parseInt(year);
        int difday = resultdayn-resultday;
        int difmonth = resultmonthn-resultmonth;
        int difyear = resultyearn-resultyear;
        if(difmonth<0)
                age = difyear - 1;
        else
        {
            if(difday<0)
                age = difyear -1;
            else
                age = difyear;
        }
        return age;
    }

    static class java {

        public java() {
        }
    }
}
