/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.dk.domain.Attendance;
import za.gov.dk.domain.Employee;
import za.gov.dk.domain.Grade;
import za.gov.dk.domain.School;
import za.gov.dk.domain.Student;
import za.gov.dk.domain.Subject;
import za.gov.dk.service.AttendanceServiceLocal;
import za.gov.dk.service.EmployeeServiceLocal;
import za.gov.dk.service.GradeServiceLocal;
import za.gov.dk.service.SchoolServiceLocal;
import za.gov.dk.service.StudentServiceLocal;
import za.gov.dk.service.SubjectServiceLocal;

@ManagedBean
@ViewScoped
public class AttendanceBean extends BaseBean {

    @Autowired
    private AttendanceServiceLocal attendanceService;
    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private SubjectServiceLocal subjectService;
    @Autowired
    private GradeServiceLocal gradeService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private SchoolServiceLocal schoolService;

    List<Attendance> attendances = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();

    private Attendance attendance;
    private Subject subject;
    private Grade grade;
    private Employee employee;
    private Student student;
    private School school;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);

        attendances = attendanceService.listAll();
        students = studentService.listAll();
        subjects = subjectService.listAll();
        grades = gradeService.listAll();
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
    }

    public void addOrUpdate(Attendance att) {
        this.resetView(false).setAdd(true);
        if (att != null) {
            att.setUpdatedBy(getActiveUser().getIdentifier());
            att.setUpdatedDate(new Date());
            attendance = att;
        } else {
            attendance = new Attendance();
            attendance.setCreatedBy(getActiveUser().getIdentifier());
            attendance.setCreatedDate(new Date());

            attendances.add(0, attendance);
        }
    }

    public void save(Attendance att) {
        if (att.getId() != null) {
            attendanceService.update(att);
        } else {
            attendanceService.save(att);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Attendance att) {
        attendanceService.deleteById(att.getId());
        synchronize(att);
        this.resetView(false).setList(true);
    }

    public void synchronize(Attendance att) {
        Iterator<Attendance> attendanceList = attendances.iterator();
        while (attendanceList.hasNext()) {
            if (attendanceList.next().getId().equals(att.getId())) {
                attendanceList.remove();
            }
        }
    }

    public void cancel(Attendance att) {
        if (attendances.contains(att)) {
            attendances.remove(att);
        }
        this.resetView(false).setList(true);
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
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
