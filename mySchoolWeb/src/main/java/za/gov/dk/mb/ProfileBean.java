/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.mb;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.dk.domain.Address;
import za.gov.dk.domain.ContactDetail;
import za.gov.dk.domain.Employee;
import za.gov.dk.domain.SchoolUser;
import za.gov.dk.domain.Student;
import za.gov.dk.service.EmployeeServiceLocal;
import za.gov.dk.service.SchoolUserServiceLocal;
import za.gov.dk.service.StudentServiceLocal;

/**
 *
 * @author S2028389
 */
@ManagedBean
@ViewScoped
public class ProfileBean extends BaseBean {

    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private SchoolUserServiceLocal systemUserService;

    private Employee staff;
    private Student candidate;
    private SchoolUser systemUser;

    @PostConstruct
    public void init() {
        staff = employeeService.findEmployeeByEmployeeNum(getActiveUser().getIdentifier());
        candidate = studentService.findStudentByStudentNum(getActiveUser().getIdentifier());
        systemUser = systemUserService.findSystemUserbyIdentfier(getActiveUser().getIdentifier());
    }

    public void saveEmployee(Employee emp, SchoolUser user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            employeeService.update(emp);

            user.setFirstName(emp.getFirstName());
            user.setLastName(emp.getLastName());
            user.setIdentityNumber(emp.getIdentityNumber());
            user.setIdentifier(emp.getEmployeeId());
            user.setGenderType(emp.getGenderType());

            for (Address address : emp.getAddressList()) {
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
            contactDetail.setCellphone_number(emp.getContactDetail().getCellphone_number());
            contactDetail.setTellphone_number(emp.getContactDetail().getTellphone_number());
            contactDetail.setEmailAddress(emp.getContactDetail().getEmailAddress());
            user.setContactDetail(contactDetail);
            systemUserService.update(user);
        } else {
            addWarningMessage("The password provided is not the same as the confirmation, please check and try again");
        }
    }

    public void saveStudent(Student std, SchoolUser user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            studentService.update(std);
            systemUserService.update(user);

            user.setFirstName(std.getFirstName());
            user.setLastName(std.getLastName());
            user.setIdentityNumber(std.getIdentityNumber());
            user.setIdentifier(std.getStudentNumber());
            user.setGenderType(std.getGenderType());

            for (Address address : std.getAddressList()) {
                Address address1c = new Address();
                address1c.setCreatedBy(getActiveUser().getIdentifier());
                address1c.setCreatedDate(new Date());
                address1c.setAddressType(address.getAddressType().RESIDENTIAL);
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
            contactDetail.setCellphone_number(std.getContactDetail().getCellphone_number());
            contactDetail.setTellphone_number(std.getContactDetail().getTellphone_number());
            contactDetail.setEmailAddress(std.getContactDetail().getEmailAddress());
            user.setContactDetail(contactDetail);
            systemUserService.update(user);
        } else {
            addWarningMessage("The password provided is not the same as the confirmation, please check and try again");
        }
    }

    public void cancel() {
        redirecting("/pages/landing");
    }

    public Employee getStaff() {
        return staff;
    }

    public void setStaff(Employee staff) {
        this.staff = staff;
    }

    public Student getCandidate() {
        return candidate;
    }

    public void setCandidate(Student candidate) {
        this.candidate = candidate;
    }

    public SchoolUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SchoolUser systemUser) {
        this.systemUser = systemUser;
    }

}
