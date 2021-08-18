/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.common;

/**
 *
 * @author S2028389
 */
public enum SchoolUserType {
    SYSTEM_ADMIN("System_Admin"),
    LEARNER("Learner"),
    EMPLOYEE("Employee");

    private final String displayname;

    SchoolUserType(final String displayName) {
        this.displayname = displayName;
    }

    public String getDisplayname() {
        return displayname;
    }

    public String toString() {
        return this.displayname;
    }
}
