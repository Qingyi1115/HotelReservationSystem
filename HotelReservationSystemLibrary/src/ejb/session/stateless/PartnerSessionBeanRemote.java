/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.Partner;
import entity.Reservation;
import java.util.List;
import javax.ejb.Remote;
import util.exception.InputDataValidationException;
import util.exception.InvalidLoginCredentialException;
import util.exception.PartnerUsernameExistException;
import util.exception.ReservationNotFoundException;
import util.exception.UnknownPersistenceException;

/**
 *
 * @author xqy11
 */
@Remote
public interface PartnerSessionBeanRemote {

    public Partner partnerLogin(String username, String password) throws InvalidLoginCredentialException;

    public Partner retrievePartnerByUsername(String username) throws PartnerUsernameExistException;

    public List<Partner> retrieveAllPartners();

    public Long createNewPartner(Partner newPartnerEntity) throws PartnerUsernameExistException, UnknownPersistenceException, InputDataValidationException;

    public List<Reservation> retrieveAllReservationsByPartnerId(Long partnerId);
    
    public Reservation retrieveReservationsByReservationId(Long reservationId) throws ReservationNotFoundException;

    public List<Reservation> retrieveReservationsByPartnerId(Long partnerId);
}
