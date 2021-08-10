/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.mb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.dk.common.AddressType;
import za.gov.dk.common.Gender;
import za.gov.dk.common.PersonType;
import za.gov.dk.common.SchoolUserStatus;
import za.gov.dk.common.SchoolUserType;
import za.gov.dk.domain.Address;
import za.gov.dk.domain.ContactDetail;
import za.gov.dk.domain.Employee;
import za.gov.dk.domain.School;
import za.gov.dk.domain.SchoolUser;
import za.gov.dk.domain.Student;
import za.gov.dk.service.EmployeeServiceLocal;
import za.gov.dk.service.SchoolServiceLocal;
import za.gov.dk.service.SchoolUserServiceLocal;
import za.gov.dk.service.StudentServiceLocal;

/**
 *
 * @author S2028389
 */
@ManagedBean
@ViewScoped
public class SchoolUserBean extends BaseBean {

    @Autowired
    private SchoolUserServiceLocal systemUserService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private SchoolServiceLocal schoolService;

    private List<SchoolUser> systemUsers = new ArrayList();
    private List<Employee> employees = new ArrayList();
    private List<Student> students = new ArrayList();

    private List<SchoolUserType> systemUserType;
    private List<AddressType> addressType;
    private List<Gender> gender;
    private List<SchoolUserStatus> systemUserStatus;

    private SchoolUser systemUser;
    private Student student;
    private Employee employee;
    private School school;

    private ActiveUser activeUser;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        systemUsers = systemUserService.listAll();
        employees = employeeService.listAll();
        students = studentService.listAll();
        addressType = Arrays.asList(AddressType.values());
        gender = Arrays.asList(Gender.values());
        systemUserType = Arrays.asList(SchoolUserType.values());
        systemUserStatus = Arrays.asList(SchoolUserStatus.values());
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
    }

    public void addorUpdate(SchoolUser user) {
        this.resetView(false).setAdd(true);
        if (user != null) {
            if (user.getSystemUserType().equals(SchoolUserType.EMPLOYEE)) {
                employee = employeeService.findEmployeeByEmployeeNum(user.getIdentifier());
            } else if (user.getSystemUserType().equals(SchoolUserType.SYSTEM_ADMIN)) {
                employee = employeeService.findEmployeeByEmployeeNum(user.getIdentifier());
            } else if (user.getSystemUserType().equals(SchoolUserType.LEARNER)) {
                student = studentService.findStudentByStudentNum(user.getIdentifier());
            }
            user.setUpdatedBy(getActiveUser().getIdentifier());
            user.setUpdatedDate(new Date());
            systemUser = user;
        } else {
            systemUser = new SchoolUser();
            systemUser.setCreatedBy("");
            systemUser.setCreatedDate(new Date());
            systemUser.setSchool(school);
            systemUser.setPersonType(PersonType.SYSTEM_USER);

            systemUsers.add(0, systemUser);
        }
    }

    public void save(SchoolUser user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (user.getId() != null) {
                user.setCreatedBy(getActiveUser().getIdentifier());
                user.setUpdatedDate(new Date());
                systemUserService.update(user);
            } else {

                if(userExist(user)){
                    if (user.getSystemUserType().equals(SchoolUserType.EMPLOYEE) || user.getSystemUserType().equals(SchoolUserType.SYSTEM_ADMIN)) {

                        employee = employeeService.findEmployeeByEmployeeNum(user.getIdentifier());
                        user.setFirstName(employee.getFirstName());
                        user.setLastName(employee.getLastName());
                        user.setIdentityNumber(employee.getIdentityNumber());
                        user.setGenderType(employee.getGenderType());

                        for (Address address : employee.getAddressList()) {
                            Address address1c = new Address();
                            address1c.setCreatedBy(getActiveUser().getIdentifier());
                            address1c.setCreatedDate(new Date());
                            address1c.setAddressType(address.getAddressType());
                            address1c.setAddressLine1(address.getAddressLine1());
                            address1c.setAddressLine2(address.getAddressLine2());
                            address1c.setStreet(address.getStreet());
                            address1c.setArea(address.getArea());
                            address1c.setCode(address.getCode());
                            user.addAddress(address1c);
                        }
                        ContactDetail contactDetail = new ContactDetail();
                        contactDetail.setCreatedBy(getActiveUser().getIdentifier());
                        contactDetail.setCreatedDate(new Date());
                        contactDetail.setCellphone_number(employee.getContactDetail().getCellphone_number());
                        contactDetail.setTellphone_number(employee.getContactDetail().getTellphone_number());
                        contactDetail.setEmailAddress(employee.getContactDetail().getEmailAddress());
                        user.setContactDetail(contactDetail);

                        systemUserService.save(user);
                    } else if (user.getSystemUserType().equals(SchoolUserType.LEARNER)) {
                        student = studentService.findStudentByStudentNum(user.getIdentifier());
                        user.setFirstName(student.getFirstName());
                        user.setLastName(student.getLastName());
                        user.setIdentityNumber(student.getIdentityNumber());
                        user.setGenderType(student.getGenderType());

                        for (Address address : student.getAddressList()) {
                            Address address1 = new Address();
                            address1.setCreatedBy(getActiveUser().getIdentifier());
                            address1.setCreatedDate(new Date());
                            address1.setAddressType(address.getAddressType());
                            address1.setAddressLine1(address.getAddressLine1());
                            address1.setAddressLine2(address.getAddressLine2());
                            address1.setStreet(address.getStreet());
                            address1.setArea(address.getArea());
                            address1.setCode(address.getCode());
                            user.addAddress(address1);
                        }
                        ContactDetail contactDetail2 = new ContactDetail();
                        contactDetail2.setCreatedBy(getActiveUser().getIdentifier());
                        contactDetail2.setCreatedDate(new Date());
                        contactDetail2.setCellphone_number(student.getContactDetail().getCellphone_number());
                        contactDetail2.setTellphone_number(student.getContactDetail().getCellphone_number());
                        contactDetail2.setEmailAddress(student.getContactDetail().getEmailAddress());
                        user.setContactDetail(contactDetail2);
                        systemUserService.save(user);
                    }
                } else {
                    addWarningMessage("The person you try to register to register Already Exist as User!");
                }
            }
            this.resetView(false).setList(true);

        } else {
            addWarningMessage("Password provided is not the same as the confirmation password,check your password please!");
        }
    }
    public void  cancel(SchoolUser user1){}
    public void addOrUpdate(SchoolUser user1){}
     public void delete(SchoolUser user1){}
    

    public List<String> getIdentifiers() {
        List<String> allIdentifiers = new ArrayList();
        for (SchoolUser user : systemUserService.listAll()) {
            allIdentifiers.add(user.getIdentifier());
        }

        return allIdentifiers;
    }

    public void systemUserTypeListener() {
        if ((systemUser.getSystemUserType().equals(SchoolUserType.EMPLOYEE)) || (systemUser.getSystemUserType().equals(SchoolUserType.SYSTEM_ADMIN))) {
            setVisible(false);
            setVisiblePage(true);

        } else if (systemUser.getSystemUserType().equals(SchoolUserType.LEARNER)) {
            setVisiblePage(false);
            setVisible(true);
        }
    }

    public boolean userExist(SchoolUser user) {
        for (SchoolUser syst : systemUserService.listAll()) {
            if (user.getIdentifier().equals(syst.getIdentifier())) {
                return true;
            }
        }
        return false;
    }

    public List<SchoolUser> getSystemUsers() {
        return systemUsers;
    }

    public void setSystemUsers(List<SchoolUser> systemUsers) {
        this.systemUsers = systemUsers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<SchoolUserType> getSystemUserType() {
        return systemUserType;
    }

    public void setSystemUserType(List<SchoolUserType> systemUserType) {
        this.systemUserType = systemUserType;
    }

    public List<AddressType> getAddressType() {
        return addressType;
    }

    public void setAddressType(List<AddressType> addressType) {
        this.addressType = addressType;
    }

    public List<Gender> getGender() {
        return gender;
    }

    public void setGender(List<Gender> gender) {
        this.gender = gender;
    }

    public List<SchoolUserStatus> getSystemUserStatus() {
        return systemUserStatus;
    }

    public void setSystemUserStatus(List<SchoolUserStatus> systemUserStatus) {
        this.systemUserStatus = systemUserStatus;
    }

    public SchoolUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SchoolUser systemUser) {
        this.systemUser = systemUser;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    

}
