/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.dk.domain.Facility;
import za.gov.dk.persistence.FacilityRepository;

/**
 *
 * @author S2028389
 */
@Service
public class FacilityService implements FacilityServiceLocal {
    
     @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public Facility save(Facility employee) {
        return facilityRepository.save(employee);
    }

    public Facility findById(Long id) {
        return facilityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public Facility update(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public void deleteAll() {
        facilityRepository.deleteAll();
    }

    @Override
    public Facility deleteById(Long id) {
        Facility fa = findById(id);
        if (fa != null) {
            facilityRepository.deleteById(id);
        }
        return fa;
    }

    @Override
    public List<Facility> findFacilityByFacilityNum(String facilityNum) {
        //Advanced code to be demonstrated later
        return facilityRepository.findAll();
    }

    @Override
    public List<Facility> listAll() {
        return facilityRepository.findAll();
    }

    @Override
    public boolean isExist(Facility facility) {
        return facilityRepository.findById(facility.getId()) != null;
    }

    @Override
    public long count() {
        return facilityRepository.count();
    }

}
