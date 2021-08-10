/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.dk.domain.Assessment;
import za.gov.dk.persistence.AssessmentRepository;

/**
 *
 * @author S2028389
 */
@Service
public class AssessmentService implements AssessmentServiceLocal {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Override
    public Assessment save(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    public Assessment findById(Long id) {
        return assessmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public Assessment update(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @Override
    public void deleteAll() {
        assessmentRepository.deleteAll();
    }

    @Override
    public Assessment deleteById(Long id) {
        Assessment ass = findById(id);
        if (ass != null) {
            assessmentRepository.deleteById(id);
        }
        return ass;
    }

    @Override
    public List<Assessment> findAssessmentByAssessmentNum(String assessmentNum) {
        //Advanced code to be demonstrated later
        return assessmentRepository.findAll();
    }

    @Override
    public List<Assessment> listAll() {
        return assessmentRepository.findAll();
    }

    @Override
    public boolean isExist(Assessment assessment) {
        return assessmentRepository.findById(assessment.getId()) != null;
    }

    @Override
    public long count() {
        return assessmentRepository.count();
    }

}
