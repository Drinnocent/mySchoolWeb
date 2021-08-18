/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.gov.dk.domain.SchoolUser;

/**
 *
 * @author S2028389
 */
@Repository
public interface SchoolUserRepository extends JpaRepository<SchoolUser, Long> {

    @Query("SELECT e FROM  SchoolUser e WHERE e.username=:username")
    public SchoolUser searchByUsername(@Param("username") String username);

    @Query("SELECT e FROM  SchoolUser e WHERE e.identifier=:identifier")
    public SchoolUser findSystemUserbyIdentfier(@Param("identifier") String identifier);

}
