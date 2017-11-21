/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx.Class;

/**
 *
 * @author terkg
 */
public class DiamonAccount extends Account {

    public DiamonAccount(String dateOfBirth, String email, String firstname, String lastname) {
        super(dateOfBirth, email, firstname, lastname);
    }

    @Override
    public int discount() {
        return 20;
    }

}
