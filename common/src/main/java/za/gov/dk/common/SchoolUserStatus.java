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
public enum SchoolUserStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    SUSPEDEND("Suspended");
    
    private final String displayName;

    SchoolUserStatus(final String displayName) {
        this.displayName = displayName;
    }
    @Override
    public String toString() {
        return displayName;
    }

   
}
