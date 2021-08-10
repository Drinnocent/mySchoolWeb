/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.Date;
import za.gov.dk.common.EmployeeType;
import za.gov.dk.common.PersonType;
import za.gov.dk.common.SchoolUserStatus;
import za.gov.dk.common.SchoolUserType;
import za.gov.dk.domain.Address;
import za.gov.dk.domain.ContactDetail;
import za.gov.dk.domain.Employee;
import za.gov.dk.domain.SchoolUser;
import za.gov.dk.domain.Student;
import za.gov.dk.persistence.EmployeeRepository;
import za.gov.dk.persistence.SchoolUserRepository;
import za.gov.dk.persistence.StudentRepository;

/**
 *
 * @author S2028389
 */
public class SystemUserHelper {

    public static void addSystemUser(SchoolUserRepository systemUserRepository, EmployeeRepository employeeRepository, StudentRepository studentRepository) {
        int adminCount = 1;
        int employeeCount = 1;
        for (Employee employee : employeeRepository.findAll()) {
            if (employee.getEmployeeType().equals(EmployeeType.ADMIN)) {
                SchoolUser systemUser = new SchoolUser();

                systemUser.setCreatedBy("Test");
                systemUser.setCreatedDate(new Date());
                systemUser.setFirstName(employee.getFirstName());
                systemUser.setLastName(employee.getLastName());
                systemUser.setIdentityNumber(employee.getIdentityNumber());
                systemUser.setPersonType(PersonType.SYSTEM_USER);
                systemUser.setSystemUserType(SchoolUserType.SYSTEM_ADMIN);
                systemUser.setSystemUserStatus(SchoolUserStatus.ACTIVE);
                systemUser.setIdentifier(employee.getEmployeeId());
                systemUser.setGenderType(employee.getGenderType());
                systemUser.setUsername("admin" + adminCount);
                systemUser.setPassword("admin" + adminCount);
                systemUser.setChangePassword(false);
                systemUser.setSchool(employee.getSchool());

                for (Address address : employee.getAddressList()) {
                    Address newaddress = new Address();
                    newaddress.setCreatedBy("Lethu");
                    newaddress.setCreatedDate(new Date());
                    newaddress.setAddressType(address.getAddressType());
                    newaddress.setAddressLine1(address.getAddressLine1());
                    newaddress.setAddressLine2(address.getAddressLine2());
                    newaddress.setStreet(address.getStreet());
                    newaddress.setArea(address.getArea());
                    newaddress.setCode(address.getCode());
                    systemUser.addAddress(newaddress);

                }

                ContactDetail contactDetail1 = new ContactDetail();
                contactDetail1.setCreatedBy("Dk");
                contactDetail1.setCreatedDate(new Date());
                contactDetail1.setCellphone_number(employee.getContactDetail().getCellphone_number());
                contactDetail1.setTellphone_number(employee.getContactDetail().getTellphone_number());
                contactDetail1.setEmailAddress(employee.getContactDetail().getEmailAddress());
                systemUser.setContactDetail(contactDetail1);

                systemUserRepository.save(systemUser);
                adminCount++;

            }

            if (employee.getEmployeeType().equals(EmployeeType.EDUCATOR)) {
                SchoolUser systemUser2 = new SchoolUser();

                systemUser2.setCreatedBy("Test");
                systemUser2.setCreatedDate(new Date());
                systemUser2.setFirstName(employee.getFirstName());
                systemUser2.setLastName(employee.getLastName());
                systemUser2.setIdentityNumber(employee.getIdentityNumber());
                systemUser2.setPersonType(PersonType.SYSTEM_USER);
                systemUser2.setSystemUserType(SchoolUserType.EMPLOYEE);
                systemUser2.setSystemUserStatus(SchoolUserStatus.ACTIVE);
                systemUser2.setIdentifier(employee.getEmployeeId());
                systemUser2.setGenderType(employee.getGenderType());
                systemUser2.setUsername("employee" + employeeCount);
                systemUser2.setPassword("employee" + employeeCount);
                systemUser2.setChangePassword(false);
                systemUser2.setSchool(employee.getSchool());

                for (Address address : employee.getAddressList()) {
                    Address newaddress = new Address();
                    newaddress.setCreatedBy("Lethu");
                    newaddress.setCreatedDate(new Date());
                    newaddress.setAddressType(address.getAddressType());
                    newaddress.setAddressLine1(address.getAddressLine1());
                    newaddress.setAddressLine2(address.getAddressLine2());
                    newaddress.setStreet(address.getStreet());
                    newaddress.setArea(address.getArea());
                    newaddress.setCode(address.getCode());
                    systemUser2.addAddress(newaddress);

                }

                ContactDetail contactDetail1 = new ContactDetail();
                contactDetail1.setCreatedBy("Dk");
                contactDetail1.setCreatedDate(new Date());
                contactDetail1.setCellphone_number(employee.getContactDetail().getCellphone_number());
                contactDetail1.setTellphone_number(employee.getContactDetail().getTellphone_number());
                contactDetail1.setEmailAddress(employee.getContactDetail().getEmailAddress());
                systemUser2.setContactDetail(contactDetail1);

                systemUserRepository.save(systemUser2);
                employeeCount++;

            }

            if (employee.getEmployeeType().equals(EmployeeType.PRINCIPAL)) {
                SchoolUser systemUser3 = new SchoolUser();

                systemUser3.setCreatedBy("Test");
                systemUser3.setCreatedDate(new Date());
                systemUser3.setFirstName(employee.getFirstName());
                systemUser3.setLastName(employee.getLastName());
                systemUser3.setIdentityNumber(employee.getIdentityNumber());
                systemUser3.setPersonType(PersonType.SYSTEM_USER);
                systemUser3.setSystemUserType(SchoolUserType.EMPLOYEE);
                systemUser3.setSystemUserStatus(SchoolUserStatus.ACTIVE);
                systemUser3.setIdentifier(employee.getEmployeeId());
                systemUser3.setGenderType(employee.getGenderType());
                systemUser3.setUsername("employee" + employeeCount);
                systemUser3.setPassword("employee" + employeeCount);
                systemUser3.setChangePassword(false);
                systemUser3.setSchool(employee.getSchool());

                for (Address address : employee.getAddressList()) {
                    Address newaddress = new Address();
                    newaddress.setCreatedBy("Lethu");
                    newaddress.setCreatedDate(new Date());
                    newaddress.setAddressType(address.getAddressType());
                    newaddress.setAddressLine1(address.getAddressLine1());
                    newaddress.setAddressLine2(address.getAddressLine2());
                    newaddress.setStreet(address.getStreet());
                    newaddress.setArea(address.getArea());
                    newaddress.setCode(address.getCode());
                    systemUser3.addAddress(newaddress);

                }

                ContactDetail contactDetail1 = new ContactDetail();
                contactDetail1.setCreatedBy("Dk");
                contactDetail1.setCreatedDate(new Date());
                contactDetail1.setCellphone_number(employee.getContactDetail().getCellphone_number());
                contactDetail1.setTellphone_number(employee.getContactDetail().getTellphone_number());
                contactDetail1.setEmailAddress(employee.getContactDetail().getEmailAddress());
                systemUser3.setContactDetail(contactDetail1);

                systemUserRepository.save(systemUser3);
                employeeCount++;

            }

            if (employee.getEmployeeType().equals(EmployeeType.HOD)) {
                SchoolUser systemUser4 = new SchoolUser();

                systemUser4.setCreatedBy("Test");
                systemUser4.setCreatedDate(new Date());
                systemUser4.setFirstName(employee.getFirstName());
                systemUser4.setLastName(employee.getLastName());
                systemUser4.setIdentityNumber(employee.getIdentityNumber());
                systemUser4.setPersonType(PersonType.SYSTEM_USER);
                systemUser4.setSystemUserType(SchoolUserType.EMPLOYEE);
                systemUser4.setSystemUserStatus(SchoolUserStatus.ACTIVE);
                systemUser4.setIdentifier(employee.getEmployeeId());
                systemUser4.setGenderType(employee.getGenderType());
                systemUser4.setUsername("employee" + employeeCount);
                systemUser4.setPassword("employee" + employeeCount);
                systemUser4.setChangePassword(false);
                systemUser4.setSchool(employee.getSchool());

                for (Address address : employee.getAddressList()) {
                    Address newaddress = new Address();
                    newaddress.setCreatedBy("Lethu");
                    newaddress.setCreatedDate(new Date());
                    newaddress.setAddressType(address.getAddressType());
                    newaddress.setAddressLine1(address.getAddressLine1());
                    newaddress.setAddressLine2(address.getAddressLine2());
                    newaddress.setStreet(address.getStreet());
                    newaddress.setArea(address.getArea());
                    newaddress.setCode(address.getCode());
                    systemUser4.addAddress(newaddress);

                }

                ContactDetail contactDetail1 = new ContactDetail();
                contactDetail1.setCreatedBy("Dk");
                contactDetail1.setCreatedDate(new Date());
                contactDetail1.setCellphone_number(employee.getContactDetail().getCellphone_number());
                contactDetail1.setTellphone_number(employee.getContactDetail().getTellphone_number());
                contactDetail1.setEmailAddress(employee.getContactDetail().getEmailAddress());
                systemUser4.setContactDetail(contactDetail1);

                systemUserRepository.save(systemUser4);
                employeeCount++;

            }

        }
        int studentcount = 1;
        for (Student student : studentRepository.findAll()) {

            SchoolUser systemUser5 = new SchoolUser();

            systemUser5.setCreatedBy("Test");
            systemUser5.setCreatedDate(new Date());
            systemUser5.setFirstName(student.getFirstName());
            systemUser5.setLastName(student.getLastName());
            systemUser5.setIdentityNumber(student.getIdentityNumber());
            systemUser5.setPersonType(PersonType.SYSTEM_USER);
            systemUser5.setSystemUserType(SchoolUserType.LEARNER);
            systemUser5.setSystemUserStatus(SchoolUserStatus.ACTIVE);
            systemUser5.setIdentifier(student.getStudentNumber());
            systemUser5.setGenderType(student.getGenderType());
            systemUser5.setUsername("student" + studentcount);
            systemUser5.setPassword("student" + studentcount);
            systemUser5.setChangePassword(false);
            systemUser5.setSchool(student.getSchool());

            for (Address address : student.getAddressList()) {
                Address newaddress = new Address();
                newaddress.setCreatedBy("Lethu");
                newaddress.setCreatedDate(new Date());
                newaddress.setAddressType(address.getAddressType());
                newaddress.setAddressLine1(address.getAddressLine1());
                newaddress.setAddressLine2(address.getAddressLine2());
                newaddress.setStreet(address.getStreet());
                newaddress.setArea(address.getArea());
                newaddress.setCode(address.getCode());
                systemUser5.addAddress(newaddress);

            }

            ContactDetail contactDetail1 = new ContactDetail();
            contactDetail1.setCreatedBy("Dk");
            contactDetail1.setCreatedDate(new Date());
            contactDetail1.setCellphone_number(student.getContactDetail().getCellphone_number());
            contactDetail1.setTellphone_number(student.getContactDetail().getTellphone_number());
            contactDetail1.setEmailAddress(student.getContactDetail().getEmailAddress());
            systemUser5.setContactDetail(contactDetail1);

            systemUserRepository.save(systemUser5);
            studentcount++;

        }

    }
}
