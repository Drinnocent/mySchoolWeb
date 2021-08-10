    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.Date;
import za.gov.dk.domain.Assessment;
import za.gov.dk.persistence.AssessmentRepository;
import za.gov.dk.persistence.EmployeeRepository;
import za.gov.dk.persistence.StudentRepository;

/**
 *
 * @author S2028389
 */
public class AssessmentHelper {

    public static void addAssessment(AssessmentRepository assessmentRepository, EmployeeRepository employeeRepository, StudentRepository studentRepository) {
        Assessment assessment = new Assessment();
        assessment.setCreatedBy("Dr");
        assessment.setCreatedDate(new Date());
        assessment.setName("Maths Asss");
        assessment.setDescription("Class test");
        assessment.setPassMark(80.00);
        assessment.setStudentmark(50);
        assessment.setDueDate(new Date());
        assessment.setTotalMark(95.00);
       // assessment.setStudent(studentRepository.findAll().get(studentRepository.findAll().size() - 2));
        // assessment.setEducator(employeeRepository.findAll().get(employeeRepository.findAll().size() - 1));
        assessmentRepository.save(assessment);

        Assessment assessment2 = new Assessment();
        assessment2.setCreatedBy("Dr");
        assessment2.setCreatedDate(new Date());
        assessment2.setName("Physics Asss");
        assessment2.setDescription("Class test");
        assessment2.setPassMark(80.00);
        assessment2.setStudentmark(50);
        assessment2.setDueDate(new Date());
        assessment2.setTotalMark(95.00);

       // assessment2.setStudent(studentRepository.findAll().get(studentRepository.findAll().size() - 1));
        // assessment2.setEducator(employeeRepository.findAll().get(employeeRepository.findAll().size() - 1));
        assessmentRepository.save(assessment2);

        Assessment assessment3 = new Assessment();
        assessment3.setCreatedBy("Dr");
        assessment3.setCreatedDate(new Date());
        assessment3.setName("English Asss");
        assessment3.setDescription("Class test");
        assessment3.setPassMark(80.00);
        assessment3.setStudentmark(50);
        assessment3.setDueDate(new Date());
        assessment3.setTotalMark(95.00);

        //assessment3.setStudent(studentRepository.findAll().get(studentRepository.findAll().size() - 2));
        //assessment3.setEducator(employeeRepository.findAll().get(employeeRepository.findAll().size() - 1));
        assessmentRepository.save(assessment3);

        Assessment assessment4 = new Assessment();
        assessment4.setCreatedBy("Dr");
        assessment4.setCreatedDate(new Date());
        assessment4.setName("English Asss");
        assessment4.setDescription("Class test");
        assessment4.setPassMark(80.00);
        assessment4.setStudentmark(50);
        assessment4.setDueDate(new Date());
        assessment4.setTotalMark(95.00);

        //assessment4.setStudent(studentRepository.findAll().get(studentRepository.findAll().size() - 2));
        //assessment4.setEducator(employeeRepository.findAll().get(employeeRepository.findAll().size() - 1));
        assessmentRepository.save(assessment4);

        Assessment assessment5 = new Assessment();
        assessment5.setCreatedBy("Dr");
        assessment5.setCreatedDate(new Date());
        assessment5.setName("English Asss");
        assessment5.setDescription("Class test");
        assessment5.setPassMark(80.00);
        assessment5.setStudentmark(50);
        assessment5.setDueDate(new Date());
        assessment5.setTotalMark(95.00);

        //assessment5.setStudent(studentRepository.findAll().get(studentRepository.findAll().size() - 2));
        //assessment5.setEducator(employeeRepository.findAll().get(employeeRepository.findAll().size() - 1));
        assessmentRepository.save(assessment5);

    }

}
