/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.RegisteredGuest;
import javax.ejb.Local;
import util.exception.GuestNotFoundException;

/**
 *
 * @author msipc
 */
@Local
public interface GuestSessionBeanLocal {

    public RegisteredGuest retrieveRegisteredGuestByID(String ID) throws GuestNotFoundException;
    
}
