/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.mb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.dk.domain.Assessment;
import za.gov.dk.domain.Employee;
import za.gov.dk.domain.Grade;
import za.gov.dk.domain.Student;
import za.gov.dk.domain.Subject;
import za.gov.dk.service.AssessmentServiceLocal;
import za.gov.dk.service.EmployeeServiceLocal;
import za.gov.dk.service.StudentServiceLocal;


/**
 *
 * @author S2028389
 */
@ManagedBean
@ViewScoped
public class AssessmentBean extends BaseBean {

    @Autowired
    private AssessmentServiceLocal assessmentService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;

    private List<Assessment> assessments = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    private Assessment assessment;
    private Employee teacher;
    private Student student;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        if (getActiveUser().isLearner()) {
            student=studentService.findStudentByStudentNum(getActiveUser().getIdentifier());
            assessments=assessmentService.listAll();

        }
        else
        {
            teacher=employeeService.findEmployeeByEmployeeNum(getActiveUser().getIdentifier());
             assessments=assessmentService.listAll();
        }

    }
    public void save(Assessment ass){}
    public void addOrUpdate(Assessment ass){}
    public void cancel(Assessment ass){}
     public void delete(Assessment ass){}
    

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }
    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}
