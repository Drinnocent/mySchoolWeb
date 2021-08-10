/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import za.gov.dk.domain.Facility;

/**
 *
 * @author S2028389
 */
public interface FacilityServiceLocal {

    Facility save(Facility facility);

    Facility findById(Long id);

    Facility update(Facility facility);

    void deleteAll();

    Facility deleteById(Long id);

    List<Facility> findFacilityByFacilityNum(String facilityNum);

    List<Facility> listAll();

    boolean isExist(Facility facility);

    long count();

}
