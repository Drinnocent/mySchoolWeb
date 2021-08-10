/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.dk.common.SchoolUserType;
import za.gov.dk.domain.Employee;
import za.gov.dk.domain.School;
import za.gov.dk.domain.Student;
import za.gov.dk.service.EmployeeServiceLocal;
import za.gov.dk.service.SchoolServiceLocal;
import za.gov.dk.service.StudentServiceLocal;

/**
 *
 * @author S2028389
 */
@ManagedBean
@ViewScoped
public class LandingBean extends BaseBean {
    @Autowired
    private SchoolServiceLocal schoolService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;
    
    Employee staff;
    Student student ;
    School school;
    
    @PostConstruct 
    public void init()
    {
       school=schoolService.listAll().get(schoolService.listAll().size()-1);
       if(getActiveUser().getSystemUserType().equals(SchoolUserType.EMPLOYEE) || getActiveUser().getSystemUserType().equals(SchoolUserType.SYSTEM_ADMIN))
       {
           staff=employeeService.findEmployeeByEmployeeNum(getActiveUser().getIdentifier());
       }
       else if(getActiveUser().getSystemUserType().equals(SchoolUserType.LEARNER))
               {
                   student=studentService.findStudentByStudentNum(getActiveUser().getIdentifier());
               }
    }

    public Employee getStaff() {
        return staff;
    }

    public void setStaff(Employee staff) {
        this.staff = staff;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    
}
