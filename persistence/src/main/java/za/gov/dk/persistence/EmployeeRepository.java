/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.gov.dk.domain.Employee;

/**
 *
 * @author S2028389
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
     @Query("SELECT e FROM  Employee e WHERE e.employeeId=:employeeId")
    public Employee findEmployeeByEmployeeNum(@Param("employeeId") String employeeId);
    
}
