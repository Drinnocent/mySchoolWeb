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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import za.gov.dk.common.SchoolUserStatus;
import za.gov.dk.common.SchoolUserType;

/**
 *
 * @author S2028389
 */

@Entity
@Audited
@Table(name = "schooluser")
public class SchoolUser extends Person {

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "confirm_password")
    private String confirmPassword;
    @Column(name = "change_password")
    private boolean changePassword;
    @Column(name = "identifier")
    private String identifier;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "system_user_status")
    private SchoolUserStatus systemUserStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "system_user_type")
    private SchoolUserType systemUserType;
    
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<ContactDetail> contacts=new ArrayList();

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private School school;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isChangePassword() {
        return changePassword;
    }

    public void setChangePassword(boolean changePassword) {
        this.changePassword = changePassword;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public SchoolUserStatus getSystemUserStatus() {
        return systemUserStatus;
    }

    public void setSystemUserStatus(SchoolUserStatus systemUserStatus) {
        this.systemUserStatus = systemUserStatus;
    }

    public SchoolUserType getSystemUserType() {
        return systemUserType;
    }

    public void setSystemUserType(SchoolUserType systemUserType) {
        this.systemUserType = systemUserType;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<ContactDetail> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDetail> contacts) {
        this.contacts = contacts;
    }
    

}
