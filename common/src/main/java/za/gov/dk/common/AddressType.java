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
public enum AddressType {
    RESIDENTIAL("Residential Address"),
    POSTAL("postal_Address");
    private final String address;
    AddressType(final String address)
    {
        this.address=address;
    }
    public String toString()
    {
        return this.address;
    }
    
}
