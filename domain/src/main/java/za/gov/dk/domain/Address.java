/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import za.gov.dk.common.AddressType;

/**
 *
 * @author S2028389
 */
@Entity
@Audited
@Table(name = "address")
public class Address extends BaseEntity {

    @Column(name = "addressline_1")
    private String addressLine1;
    @Column(name = "addressline_2")
    private String addressLine2;
    @Column(name = "street")
    private String street;
    @Column(name = "are")
    private String area;
    @Column(name = "code")
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_Type")
    private AddressType addressType;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private School school;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

}
