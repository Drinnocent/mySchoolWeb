/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2028389
 */
@Entity
@Audited
@Table(name = "contact_detail")
public class ContactDetail extends BaseEntity {

    @Column(name = "cellphone_number")
    private String cellphone_number;

    @Column(name = "telephone_number")
    private String tellphone_number;

    @Column(name = "email_address")
    private String emailAddress;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private School school;

    public String getCellphone_number() {
        return cellphone_number;
    }

    public void setCellphone_number(String cellphone_number) {
        this.cellphone_number = cellphone_number;
    }

    public String getTellphone_number() {
        return tellphone_number;
    }

    public void setTellphone_number(String tellphone_number) {
        this.tellphone_number = tellphone_number;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

}
