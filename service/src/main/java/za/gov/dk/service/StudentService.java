/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.dk.domain.Student;
import za.gov.dk.persistence.StudentRepository;

/**
 *
 * @author S2028389
 */
@Service
public class StudentService implements StudentServiceLocal{
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();

    }

    @Override
    public Student deleteById(Long id) {
        Student stu = findById(id);
        if (stu != null) {
            studentRepository.deleteById(id);
        }
        return stu;
    }

    @Override
    public Student findStudentByStudentNum(String identifier) {
         return studentRepository.findStudentByStudentNum(identifier);
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean isExist(Student student) {
        return studentRepository.findById(student.getId()) != null;
    }

    @Override
    public long count() {
        return studentRepository.count();
    }
    
}
