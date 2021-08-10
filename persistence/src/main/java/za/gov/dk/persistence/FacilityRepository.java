/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.gov.dk.domain.Facility;

/**
 *
 * @author S2028389
 */
public interface FacilityRepository extends JpaRepository<Facility,Long>{
    
}
