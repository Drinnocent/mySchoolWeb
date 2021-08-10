/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.Date;
import za.gov.dk.domain.Subject;
import za.gov.dk.persistence.SchoolRepository;
import za.gov.dk.persistence.SubjectRepository;

/**
 *
 * @author S2028389
 */
public class SubjectHelper {
    public static void addSubject(SubjectRepository subjectRepository,SchoolRepository schoolRepository) {

        Subject subject1 = new Subject();
      
        subject1.setCreatedBy("Test");
        subject1.setCreatedDate(new Date());
        subject1.setName("Mathematics ");
        subject1.setCode("Math130");
        subject1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject1);

        Subject subject2 = new Subject();
        subject2.setCreatedBy("Test");
        subject2.setCreatedDate(new Date());
        subject2.setName("Computer Science ");
        subject2.setCode("comp304");
        subject2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject2);

        Subject subject3 = new Subject();
        subject3.setCreatedBy("Test");
        subject3.setCreatedDate(new Date());
        subject3.setName("ISTN ");
        subject3.setCode("ISTN313");
        subject3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject3);

        Subject subject4 = new Subject();
        subject4.setCreatedBy("Test");
        subject4.setCreatedDate(new Date());
        subject4.setName("Economics ");
        subject4.setCode("Econ102");
        subject4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject4);

        Subject subject5 = new Subject();
        subject5.setCreatedBy("Test");
        subject5.setCreatedDate(new Date());
        subject5.setName("Pychology ");
        subject5.setCode("pych104");
        subject5.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject5);
        
        Subject subject6 = new Subject();
        subject6.setCreatedBy("Test");
        subject6.setCreatedDate(new Date());
        subject6.setName("Economics ");
        subject6.setCode("econ");
        subject6.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject6);
        
        Subject subject7 = new Subject();
        subject7.setCreatedBy("Test");
        subject7.setCreatedDate(new Date());
        subject7.setName("Chemistry ");
        subject7.setCode("chem");
        subject7.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject7);

    }

}
