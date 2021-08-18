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
import za.gov.dk.common.EmployeeType;
import za.gov.dk.common.Gender;
import za.gov.dk.common.PersonType;
import za.gov.dk.domain.Address;
import za.gov.dk.domain.ContactDetail;
import za.gov.dk.domain.Employee;
import za.gov.dk.domain.Grade;
import za.gov.dk.domain.School;
import za.gov.dk.domain.Subject;
import za.gov.dk.service.EmployeeServiceLocal;
import za.gov.dk.service.GradeServiceLocal;
import za.gov.dk.service.SchoolServiceLocal;
import za.gov.dk.service.SubjectServiceLocal;

/**
 *
 * @author S2028389
 */
@ManagedBean
@ViewScoped
public class EmployeeBean extends BaseBean {

    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private GradeServiceLocal gradeservice;
    @Autowired
    private SubjectServiceLocal subjectService;
    @Autowired
    private SchoolServiceLocal schoolService;

    private List<Employee> employees = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    private List<PersonType> personType = new ArrayList<>();
    private List<EmployeeType> employeeType = new ArrayList<>();
    private List<AddressType> addressType = new ArrayList<>();
    private List<Gender> genders;

    private Employee employeed;
    private School school;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        employees = employeeService.listAll();
        grades = gradeservice.listAll();
        subjects = subjectService.listAll();
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);

        personType = Arrays.asList(PersonType.values());
        employeeType = Arrays.asList(EmployeeType.values());
        addressType = Arrays.asList(AddressType.values());
        genders = Arrays.asList(Gender.values());

    }

    public void addOrUpdate(Employee emp) {
        this.resetView(false).setAdd(true);
        if (emp != null) {
            emp.setUpdatedBy(getActiveUser().getFirstName() + " " + getActiveUser().getLastName());
            emp.setUpdatedDate(new Date());
            employeed = emp;

        } else {
            employeed = new Employee();
            employeed.setCreatedBy(getActiveUser().getIdentifier());
            employeed.setCreatedDate(new Date());
            employeed.setSchool(school);
            employeed.setPersonType(PersonType.EMPLOYEE);
          
            Address physicalAdress = new Address();
            physicalAdress.setAddressType(AddressType.RESIDENTIAL);
            physicalAdress.setCreatedBy(getActiveUser().getIdentifier());
            physicalAdress.setCreatedDate(new Date());

            Address postalAdress = new Address();
            postalAdress.setAddressType(AddressType.POSTAL);
            postalAdress.setCreatedBy(getActiveUser().getIdentifier());
            postalAdress.setCreatedDate(new Date());

            employeed.getAddressList().add(physicalAdress);
            employeed.getAddressList().add(postalAdress);

            ContactDetail contactDetail = new ContactDetail();
            contactDetail.setCreatedBy(getActiveUser().getIdentifier());

            contactDetail.setCreatedDate(new Date());
            employeed.setContactDetail(contactDetail);

            employees.add(0, employeed);

        }
    }

    public void save(Employee emp) {
        if (emp.getId() != null) {
            employeeService.update(emp);
        } else {
            employeeService.save(emp);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Employee emp) {
        employeeService.deleteById(emp.getId());
        synchronize(emp);
        this.resetView(false).setList(true);
    }

    public void synchronize(Employee emp) {
        Iterator<Employee> employeeList = employees.iterator();
        while (employeeList.hasNext()) {
            if (employeeList.next().getId().equals(emp.getId())) {
                employeeList.remove();

            }
        }

    }

    public void cancel(Employee emp) {
        if (emp.getId() == null) {
            if (employees.contains(emp)) {
                employees.remove(emp);
            }
        }

        this.resetView(false).setList(true);

    }

    public void employeeTypeListener() {
        if ((employeed.getEmployeeType().equals(EmployeeType.EDUCATOR)) || (employeed.getEmployeeType().equals(EmployeeType.HOD)) || (employeed.getEmployeeType().equals(EmployeeType.PRINCIPAL))) {
            setVisible(true);
        } else {
            setVisible(false);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<PersonType> getPersonType() {
        return personType;
    }

    public void setPersonType(List<PersonType> personType) {
        this.personType = personType;
    }

    public List<EmployeeType> getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(List<EmployeeType> employeeType) {
        this.employeeType = employeeType;
    }

    public List<AddressType> getAddressType() {
        return addressType;
    }

    public void setAddressType(List<AddressType> addressType) {
        this.addressType = addressType;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Employee getEmployeed() {
        return employeed;
    }

    public void setEmployeed(Employee employeed) {
        this.employeed = employeed;
    }

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
