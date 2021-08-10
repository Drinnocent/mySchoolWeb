/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import za.gov.dk.domain.Assessment;

/**
 *
 * @author S2028389
 */
public interface AssessmentServiceLocal {
     Assessment save(Assessment assessment);

    Assessment findById(Long id);

    Assessment update(Assessment assessment);

    void deleteAll();

    Assessment deleteById(Long id);

    List<Assessment> findAssessmentByAssessmentNum(String assessmentNum);

    List<Assessment> listAll();

    boolean isExist(Assessment assessment);

    long count();

}
