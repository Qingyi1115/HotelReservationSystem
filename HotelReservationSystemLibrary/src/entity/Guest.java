/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xqy11
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Guest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long guestId;
    @Column(nullable = false, length = 32)
    @NotNull
    @Size(min = 1, max = 32)
    private String name;
    @Column(nullable = false, unique = true, length = 9)
    @NotNull
    @Size(min = 9, max = 9)
    private String identificationNumber;
    
    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservations;

    public Guest() {
        reservations = new ArrayList<>();
    }

    public Guest(String name, String identificationNumber) {
        this();
        this.name = name;
        this.identificationNumber = identificationNumber;
    }

    
    
    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestId != null ? guestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the guestId fields are not set
        if (!(object instanceof Guest)) {
            return false;
        }
        Guest other = (Guest) object;
        if ((this.guestId == null && other.guestId != null) || (this.guestId != null && !this.guestId.equals(other.guestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Guest[ id=" + guestId + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the identificationNumber
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * @param identificationNumber the identificationNumber to set
     */
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    /**
     * @return the reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
}
