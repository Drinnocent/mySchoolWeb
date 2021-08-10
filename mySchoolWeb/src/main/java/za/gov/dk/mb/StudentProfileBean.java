/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.dk.common.PersonType;
import za.gov.dk.domain.Student;
import za.gov.dk.service.StudentService;

/**
 *
 * @author S2028389
 */
@ManagedBean
@ViewScoped
public class StudentProfileBean extends BaseBean {

    @Autowired
    private StudentService studentService;

    private Student student;

    public void init() {
        student = studentService.listAll().get(studentService.listAll().size() - 1);

    }

    public void updateStudentProfile(Student stu) {
        if (stu.getId() != null) {
            studentService.update(stu);
        }
        if (stu.getPersonType().equals(PersonType.LEARNER)) {
            redirecting("studentDash");
        }

    }

    public void cancel(Student stu) {
        if (stu.getPersonType().equals(PersonType.LEARNER)) {
            redirecting("studentDash");
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
