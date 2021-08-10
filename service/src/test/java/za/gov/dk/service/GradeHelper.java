/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.Date;
import za.gov.dk.domain.Grade;
import za.gov.dk.persistence.GradeRepository;
import za.gov.dk.persistence.SchoolRepository;

/**
 *
 * @author S2028389
 */
public class GradeHelper {

    public static void addGrade(GradeRepository gradeRepository, SchoolRepository schoolRepository) {
        Grade grade1 = new Grade();
        grade1.setCreatedBy("Test");
        grade1.setCreatedDate(new Date());
        grade1.setName("Grade 8");
        grade1.setDesignation("B");
        grade1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade1);

        Grade grade2 = new Grade();
        grade2.setCreatedBy("Test");
        grade2.setCreatedDate(new Date());
        grade2.setName("Grade 9");
        grade2.setDesignation("F");
        grade2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade2);

        Grade grade3 = new Grade();
        grade3.setCreatedBy("Test");
        grade3.setCreatedDate(new Date());
        grade3.setName("Grade 10");
        grade3.setDesignation("F");
        grade3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade3);

        Grade grade4 = new Grade();
        grade4.setCreatedBy("Test");
        grade4.setCreatedDate(new Date());
        grade4.setName("Grade 11");
        grade4.setDesignation("D");
        grade4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade4);

        Grade grade5 = new Grade();
        grade5.setCreatedBy("Test");
        grade5.setCreatedDate(new Date());
        grade5.setName("Grade 11");
        grade5.setDesignation("L");
        grade5.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade5);
        
         Grade grade6 = new Grade();
        grade6.setCreatedBy("Test");
        grade6.setCreatedDate(new Date());
        grade6.setName("Grade 12");
        grade6.setDesignation("L");
        grade6.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade6);
    }
}
