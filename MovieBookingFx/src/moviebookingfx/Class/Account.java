/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx.Class;

import java.time.LocalDateTime;

/**
 *
 * @author Sivakorn
 */
public class Account {
    private int age;
    private String dateOfBirth;
    private String email;
    private int point;
    private String firstname;
    private String lastname;
    
    Account(String dateOfBirth,String email,String firstname,String lastname){
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.point = 0;
        LocalDateTime now = java.time.LocalDateTime.now();
    }
}
