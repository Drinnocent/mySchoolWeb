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
public enum EmployeeType {

    GENERAL_WORKER("General Staff"),
    EDUCATOR("Educator"),
    PRINCIPAL("Principal"),
    HOD("Head of Department"),
    CLERK("Clerk"),
    ADMIN("Administrator");

    private final String name;

    EmployeeType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
