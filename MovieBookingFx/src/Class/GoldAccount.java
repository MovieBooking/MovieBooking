/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;
/**
 *
 * @author terkg
 */
public class GoldAccount extends Account{

    public GoldAccount(String dateOfBirth, String email, String firstname, String lastname) {
        super(dateOfBirth, email, firstname, lastname);
    }

    @Override
    public int discount() {
        return 10;
    }
    
}
