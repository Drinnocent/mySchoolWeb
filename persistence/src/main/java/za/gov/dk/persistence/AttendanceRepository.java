/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.gov.dk.domain.Attendance;

/**
 *
 * @author S2028389
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    
}
