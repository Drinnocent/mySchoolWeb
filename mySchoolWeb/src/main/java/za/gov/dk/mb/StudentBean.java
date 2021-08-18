/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.mb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.dk.common.AddressType;
import za.gov.dk.common.Gender;
import za.gov.dk.common.PersonType;
import za.gov.dk.common.SchoolUserType;
import za.gov.dk.domain.Address;
import za.gov.dk.domain.ContactDetail;
import za.gov.dk.domain.Grade;
import za.gov.dk.domain.School;
import za.gov.dk.domain.Student;
import za.gov.dk.domain.Subject;
import za.gov.dk.service.GradeService;
import za.gov.dk.service.SchoolServiceLocal;
import za.gov.dk.service.StudentServiceLocal;
import za.gov.dk.service.SubjectService;

/**
 *
 * @author S2028389
 */
@ManagedBean
@ViewScoped
public class StudentBean extends BaseBean {

    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SchoolServiceLocal schoolService;

    private List<Student> students = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();

    private List<PersonType> personTypes = new ArrayList<>();
    private List<SchoolUserType> studentTypes = new ArrayList<>();
    private List<AddressType> addressTypes = new ArrayList<>();
    private List<Gender> genders;

    private Student student;
    private School school;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        students = studentService.listAll();
        subjects = subjectService.listAll();
        grades = gradeService.listAll();

        personTypes = Arrays.asList(PersonType.values());
        addressTypes = Arrays.asList(AddressType.values());
        studentTypes = Arrays.asList(SchoolUserType.values());
        genders = Arrays.asList(Gender.values());

        school = schoolService.listAll().get(schoolService.listAll().size() - 1);

    }

    public void addOrUpdate(Student stu) {
        this.resetView(false).setAdd(true);
        if (stu != null) {
            stu.setUpdatedBy(getActiveUser().getIdentifier());
            stu.setUpdatedDate(new Date());
            student = stu;
        } else {
            student = new Student();
            student.setCreatedBy(getActiveUser().getIdentifier());
            student.setCreatedDate(new Date());
            student.setSchool(school);
            student.setPersonType(PersonType.LEARNER);

            Address physicalAddress = new Address();
            physicalAddress.setAddressType(AddressType.RESIDENTIAL);
            physicalAddress.setCreatedBy(getActiveUser().getIdentifier());
            physicalAddress.setCreatedDate(new Date());

            Address postalAddress = new Address();
            postalAddress.setAddressType(AddressType.POSTAL);
            postalAddress.setCreatedBy(getActiveUser().getIdentifier());
            postalAddress.setCreatedDate(new Date());

            student.getAddressList().add(physicalAddress);
            student.getAddressList().add(postalAddress);

            ContactDetail contactDetail = new ContactDetail();
            contactDetail.setCreatedBy(getActiveUser().getIdentifier());
            contactDetail.setCreatedDate(new Date());
            student.setContactDetail(contactDetail);

            students.add(0, student);
        }
    }

    public void save(Student stu) {
        if (stu.getId() != null) {
            studentService.update(stu);
        } else {
            studentService.save(student);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Student stu) {
        studentService.deleteById(stu.getId());
        synchronize(stu);
        this.resetView(false).setList(true);
    }

    public void synchronize(Student stu) {
        Iterator<Student> studentList = students.iterator();
        while (studentList.hasNext()) {
            if (studentList.next().getId().equals(stu.getId())) {
                studentList.remove();
            }
        }
    }

    public void cancel(Student stu) {
        if (stu.getId() == null) {
            if (students.contains(stu)) {
                students.remove(stu);
            }
            this.resetView(false).setList(true);
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<PersonType> getPersonTypes() {
        return personTypes;
    }

    public void setPersonTypes(List<PersonType> personTypes) {
        this.personTypes = personTypes;
    }

    public List<SchoolUserType> getStudentTypes() {
        return studentTypes;
    }

    public void setStudentTypes(List<SchoolUserType> studentTypes) {
        this.studentTypes = studentTypes;
    }

    public List<AddressType> getAddressTypes() {
        return addressTypes;
    }

    public void setAddressTypes(List<AddressType> addressTypes) {
        this.addressTypes = addressTypes;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

}
