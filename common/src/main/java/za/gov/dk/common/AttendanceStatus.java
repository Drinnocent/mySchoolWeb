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
public enum AttendanceStatus {

    AVAILABLE("available_Status"),
    SESSSIONED("IN SESSION"),
    CANCELLED("Cancelled"),
    POSTPONED("Postponed");

    private final String displayName;

    AttendanceStatus(final String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}
