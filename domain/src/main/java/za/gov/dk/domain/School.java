/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2028389
 */
@Entity
@Audited
@Table(name = "school")
public class School extends BaseEntity {

    @Column(name = "school_name")
    private String name;
    @Column(name = "school_website")
    private String schoolWebsite;
    @Column(name = "school_RegistrationNumber")
    private String registrationNumber;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    List<Address> address = new ArrayList();
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    ContactDetail contact ;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Facility> facilities = new ArrayList();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolWebsite() {
        return schoolWebsite;
    }

    public void setSchoolWebsite(String schoolWebsite) {
        this.schoolWebsite = schoolWebsite;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public void addAddress(Address address) {
        this.address.add(address);
    }

    public ContactDetail getContact() {
        return contact;
    }

    public void setContact(ContactDetail contact) {
        this.contact = contact;
    }

   


}
