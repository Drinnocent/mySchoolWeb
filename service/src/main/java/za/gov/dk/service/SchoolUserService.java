/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.dk.domain.SchoolUser;
import za.gov.dk.persistence.SchoolUserRepository;

/**
 *
 * @author S2028389
 */
@Service
public class SchoolUserService implements  SchoolUserServiceLocal{

    @Autowired
    private SchoolUserRepository schoolUserRepository;

    @Override
    public SchoolUser save(SchoolUser user) {
        return schoolUserRepository.save(user);
    }

    @Override
    public SchoolUser logUserIn(String username, String password) {
        SchoolUser systemUser = null;
        if (isUserExisting(username)) {
            for (SchoolUser user : schoolUserRepository.findAll()) {
                if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                    systemUser = user;
                }
            }
        }
        return systemUser;
    }

    @Override
    public boolean isUserExisting(String username) {
        int count = 0;
        for (SchoolUser user : schoolUserRepository.findAll()) {
            if (user.getUsername().equals(username)) {
                count++;
            }
        }

        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public SchoolUser findById(Long Id) {
        return schoolUserRepository.getOne(Id);
    }
    @Override
   public SchoolUser findSystemUserbyIdentfier(String identifier)
     {
         return schoolUserRepository.findSystemUserbyIdentfier(identifier);
     }
    public SchoolUser login(String username)
    {
        return schoolUserRepository.searchByUsername(username);
    }

    @Override
    public SchoolUser update(SchoolUser systemUser) {
        return schoolUserRepository.save(systemUser);
    }

    @Override
    public void deleteById(Long id) {
        schoolUserRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        schoolUserRepository.deleteAll();
    }

    @Override
    public List<SchoolUser> listAll() {
        return schoolUserRepository.findAll();
    }

}
