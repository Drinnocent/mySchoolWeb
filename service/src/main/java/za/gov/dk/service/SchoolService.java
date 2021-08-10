/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.dk.domain.School;
import za.gov.dk.persistence.SchoolRepository;

/**
 *
 * @author S2028389
 */
@Service
public class SchoolService implements SchoolServiceLocal{

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public School save(School student) {
        return schoolRepository.save(student);
    }

    @Override
    public School findById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public School update(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public void deleteAll() {
        schoolRepository.deleteAll();

    }

    @Override
    public School deleteById(Long id) {
        School stu = findById(id);
        if (stu != null) {
            schoolRepository.deleteById(id);
        }
        return stu;
    }

    @Override
    public List<School> listAll() {
        return schoolRepository.findAll();
    }

    @Override
    public boolean isExist(School school) {
        return schoolRepository.findById(school.getId()) != null;
    }

    @Override
    public long count() {
        return schoolRepository.count();
    }
}
