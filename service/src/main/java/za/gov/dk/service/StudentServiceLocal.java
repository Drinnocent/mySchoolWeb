/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import za.gov.dk.domain.Student;

/**
 *
 * @author S2028389
 */
public interface StudentServiceLocal {
    Student save(Student student);

    Student findById(Long id);

    Student update(Student student);

    void deleteAll();

    Student deleteById(Long id);

    Student findStudentByStudentNum(String studentNum);

    List<Student> listAll();

    boolean isExist(Student student);

    long count();
    
}
