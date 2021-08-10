/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import za.gov.dk.domain.SchoolUser;

/**
 *
 * @author S2028389
 */
public interface SchoolUserServiceLocal {
    
    public SchoolUser save(SchoolUser user);

    public SchoolUser logUserIn(String username, String password);

    public boolean isUserExisting(String username);

    SchoolUser findById(Long Id);
    SchoolUser findSystemUserbyIdentfier(String identifier);
    SchoolUser login(String username);

    SchoolUser update(SchoolUser systemUser);

    void deleteById(Long id);

    void deleteAll();

    List<SchoolUser> listAll();
    
}
