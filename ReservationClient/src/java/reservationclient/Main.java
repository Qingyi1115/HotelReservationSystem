/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationclient;

import ejb.session.stateless.GuestSessionBeanRemote;
import javax.ejb.EJB;

/**
 *
 * @author msipc
 */
public class Main {

    @EJB(name = "GuestSessionBeanRemote")
    private static GuestSessionBeanRemote guestSessionBeanRemote;

    
    
    public static void main(String[] args) {
        MainApp mainApp = new MainApp(guestSessionBeanRemote);
        mainApp.runApp();
    }
    
}
