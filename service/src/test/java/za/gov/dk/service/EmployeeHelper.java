/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.Date;
import za.gov.dk.common.AddressType;
import za.gov.dk.common.EmployeeType;
import za.gov.dk.common.Gender;
import za.gov.dk.common.PersonType;
import za.gov.dk.domain.Address;
import za.gov.dk.domain.ContactDetail;
import za.gov.dk.domain.Employee;
import za.gov.dk.persistence.EmployeeRepository;
import za.gov.dk.persistence.GradeRepository;
import za.gov.dk.persistence.SchoolRepository;
import za.gov.dk.persistence.SubjectRepository;

/**
 *
 * @author S2028389
 */
public class EmployeeHelper {

    public static void addEmployee(EmployeeRepository employeeRepository, SubjectRepository subjectRepository, GradeRepository gradeReposistory, SchoolRepository schoolRepository) {
        Employee employee1 = new Employee();

        employee1.setCreatedBy("Test");
        employee1.setCreatedDate(new Date());
        employee1.setFirstName("Doctor");
        employee1.setLastName("Khanyile");
        employee1.setIdentityNumber("198702106394087");
        employee1.setEmployeeId("DI121416");
        employee1.setPersonType(PersonType.EMPLOYEE);
        employee1.setSaceRegNumber("0201044");
        employee1.setEmployeeType(EmployeeType.EDUCATOR);

        employee1.setGenderType(Gender.MALE);
        employee1.setGrades(gradeReposistory.findAll());
        employee1.setSubjects(subjectRepository.findAll());
        employee1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));

        ContactDetail contact1 = new ContactDetail();
        contact1.setCreatedBy("Abelo");
        contact1.setCreatedDate(new Date());
        contact1.setCellphone_number("0685541774");
        contact1.setEmailAddress("dco@");
        contact1.setTellphone_number("031412547");
        employee1.setContactDetail(contact1);

        //address
        // address2;
        Address addr1 = new Address();
        addr1.setCreatedBy("Luke");
        addr1.setCreatedDate(new Date());
        addr1.setAddressType(AddressType.RESIDENTIAL);
        addr1.setAddressLine1("Joseph Nduli 165");
        addr1.setArea("Mpangeni");
        addr1.setCode("3880");
        addr1.setStreet("Bhubhesi");

        Address addr2 = new Address();
        addr2.setCreatedBy("Lucas");
        addr2.setCreatedDate(new Date());
        addr2.setAddressType(AddressType.POSTAL);
        addr2.setAddressLine2("P.o Box 77684");
        addr2.setArea("Mpangeni");
        addr2.setCode("3880");
        addr2.setStreet("Bhubhesi");

        employee1.addAddress(addr1);
        employee1.addAddress(addr2);
        employee1.setGrades(gradeReposistory.findAll());
        employee1.setSubjects(subjectRepository.findAll());

        employeeRepository.save(employee1);

        Employee employee2 = new Employee();

        employee2.setCreatedBy("Robben");
        employee2.setCreatedDate(new Date());
        employee2.setFirstName("Lungelo");
        employee2.setLastName("Johnson");
        employee2.setIdentityNumber("188702106394087");
        employee2.setEmployeeId("DI1214157");
        employee2.setPersonType(PersonType.EMPLOYEE);
        employee2.setSaceRegNumber("0201044");
        employee2.setEmployeeType(EmployeeType.HOD);
        employee2.setGenderType(Gender.MALE);
        employee2.setGrades(gradeReposistory.findAll());
        employee2.setSubjects(subjectRepository.findAll());
        employee2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));

        ContactDetail contact2 = new ContactDetail();
        contact2.setCreatedBy("Aphiwe");
        contact2.setCreatedDate(new Date());
        contact2.setCellphone_number("0784441774");
        contact2.setEmailAddress("dco@");
        contact2.setTellphone_number("031812547");
        employee2.setContactDetail(contact2);

        Address addrc = new Address();
        addrc.setCreatedBy("Lizy");
        addrc.setCreatedDate(new Date());
        addrc.setAddressType(AddressType.RESIDENTIAL);
        addrc.setAddressLine1("Joseph Nduli 165");
        addrc.setArea("Mpangeni");
        addrc.setCode("3880");
        addrc.setStreet("Bhubhesi");

        Address addrd = new Address();
        addrd.setCreatedBy("Luyoli");
        addrd.setCreatedDate(new Date());
        addrd.setAddressType(AddressType.POSTAL);
        addrd.setAddressLine2("P.o Box 77684");
        addrd.setArea("Mpangeni");
        addrd.setCode("3880");
        addrd.setStreet("Bhubhesi");

        employee2.addAddress(addrc);
        employee2.addAddress(addrd);

        employeeRepository.save(employee2);

        Employee employee3 = new Employee();

        employee3.setCreatedBy("Tyson");
        employee3.setCreatedDate(new Date());
        employee3.setFirstName("Vumelani");
        employee3.setLastName("Johnson");
        employee3.setIdentityNumber("188702106394087");
        employee3.setEmployeeId("DI12141511");
        employee3.setPersonType(PersonType.EMPLOYEE);
        employee3.setSaceRegNumber("0201044");
        employee3.setEmployeeType(EmployeeType.PRINCIPAL);
        employee3.setGenderType(Gender.MALE);
        employee3.setGrades(gradeReposistory.findAll());
        employee3.setSubjects(subjectRepository.findAll());
        employee3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));

        ContactDetail contact3 = new ContactDetail();
        contact3.setCreatedBy("Test");
        contact3.setCreatedDate(new Date());
        contact3.setCellphone_number("0784441774");
        contact3.setEmailAddress("dco@");
        contact3.setTellphone_number("031812547");
        employee3.setContactDetail(contact3);

        Address addre = new Address();
        addre.setCreatedBy("Luke");
        addre.setCreatedDate(new Date());
        addre.setAddressType(AddressType.RESIDENTIAL);
        addre.setAddressLine1("Joseph Nduli 165");
        addre.setArea("Mpangeni");
        addre.setCode("3880");
        addre.setStreet("Bhubhesi");

        Address addrf = new Address();
        addrf.setCreatedBy("Fred");
        addrf.setCreatedDate(new Date());
        addrf.setAddressType(AddressType.POSTAL);
        addrf.setAddressLine2("P.o Box 77684");
        addrf.setArea("Mpangeni");
        addrf.setCode("3880");
        addrf.setStreet("Bhubhesi");

        employee3.addAddress(addre);
        employee3.addAddress(addrf);

        employeeRepository.save(employee3);

        Employee employee4 = new Employee();

        employee4.setCreatedBy("Dixon");
        employee4.setCreatedDate(new Date());
        employee4.setFirstName("Lungelo");
        employee4.setLastName("Mike");
        employee4.setIdentityNumber("188702106394087");
        employee4.setEmployeeId("DI1214154565");
        employee4.setPersonType(PersonType.EMPLOYEE);
        employee4.setSaceRegNumber("0201044");
        employee4.setEmployeeType(EmployeeType.GENERAL_WORKER);
        employee4.setGenderType(Gender.MALE);
        employee4.setGrades(gradeReposistory.findAll());
        employee4.setSubjects(subjectRepository.findAll());
        employee4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));

        ContactDetail contact4 = new ContactDetail();
        contact4.setCreatedBy("Lelo");
        contact4.setCreatedDate(new Date());
        contact4.setCellphone_number("0784441774");
        contact4.setEmailAddress("dco@");
        contact4.setTellphone_number("031812547");
        employee4.setContactDetail(contact4);

        Address addrg = new Address();
        addrg.setCreatedBy("Dylan");
        addrg.setCreatedDate(new Date());
        addrg.setAddressType(AddressType.RESIDENTIAL);
        addrg.setAddressLine1("Joseph Nduli 165");
        addrg.setArea("Mpangeni");
        addrg.setCode("3880");
        addrg.setStreet("Bhubhesi");

        Address addrh = new Address();
        addrh.setCreatedBy("Mavin");
        addrh.setCreatedDate(new Date());
        addrh.setAddressType(AddressType.POSTAL);
        addrh.setAddressLine2("P.o Box 77684");
        addrh.setArea("Mpangeni");
        addrh.setCode("3880");
        addrh.setStreet("Bhubhesi");

        employee4.addAddress(addrg);
        employee4.addAddress(addrh);

        employeeRepository.save(employee4);

        Employee employee5 = new Employee();

        employee5.setCreatedBy("Lee");
        employee5.setCreatedDate(new Date());
        employee5.setFirstName("Kyla");
        employee5.setLastName("Smith");
        employee5.setIdentityNumber("188702106394087");
        employee5.setEmployeeId("DI1214155454");
        employee5.setPersonType(PersonType.EMPLOYEE);
        employee5.setSaceRegNumber("0201044");
        employee5.setEmployeeType(EmployeeType.CLERK);
        employee5.setGenderType(Gender.MALE);
        employee5.setGrades(gradeReposistory.findAll());
        employee5.setSubjects(subjectRepository.findAll());
        employee5.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));

        ContactDetail contact5 = new ContactDetail();
        contact5.setCreatedBy("Lethu");
        contact5.setCreatedDate(new Date());
        contact5.setCellphone_number("0784441774");
        contact5.setEmailAddress("dco@");
        contact5.setTellphone_number("031812547");
        employee5.setContactDetail(contact5);

        Address addri = new Address();
        addri.setCreatedBy("Isaac");
        addri.setCreatedDate(new Date());
        addri.setAddressType(AddressType.RESIDENTIAL);
        addri.setAddressLine1("Joseph Nduli 165");
        addri.setArea("Mpangeni");
        addri.setCode("3880");
        addri.setStreet("Bhubhesi");

        Address addrj = new Address();
        addrj.setCreatedBy("Regan");
        addrj.setCreatedDate(new Date());
        addrj.setAddressType(AddressType.POSTAL);
        addrj.setAddressLine2("P.o Box 77684");
        addrj.setArea("Mpangeni");
        addrj.setCode("3880");
        addrj.setStreet("Bhubhesi");

        employee5.addAddress(addri);
        employee5.addAddress(addrj);

        employeeRepository.save(employee5);

        Employee employee6 = new Employee();

        employee6.setCreatedBy("Morgan");
        employee6.setCreatedDate(new Date());
        employee6.setFirstName("Lungelo");
        employee6.setLastName("Naidoo");
        employee6.setIdentityNumber("188702106394087");
        employee6.setEmployeeId("DI12141556787");
        employee6.setPersonType(PersonType.EMPLOYEE);
        employee6.setSaceRegNumber("0201044");
        employee6.setEmployeeType(EmployeeType.ADMIN);
        employee6.setGenderType(Gender.MALE);
        employee6.setGrades(gradeReposistory.findAll());
        employee6.setSubjects(subjectRepository.findAll());
        employee6.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));

        ContactDetail contact6 = new ContactDetail();
        contact6.setCreatedBy("Miz");
        contact6.setCreatedDate(new Date());
        contact6.setCellphone_number("0784441774");
        contact6.setEmailAddress("dco@");
        contact6.setTellphone_number("031812547");
        employee6.setContactDetail(contact6);

        Address addrk = new Address();
        addrk.setCreatedBy("Kylan");
        addrk.setCreatedDate(new Date());
        addrk.setAddressType(AddressType.RESIDENTIAL);
        addrk.setAddressLine1("Joseph Nduli 165");
        addrk.setArea("Mpangeni");
        addrk.setCode("3880");
        addrk.setStreet("Bhubhesi");

        Address addrl = new Address();
        addrl.setCreatedBy("Megan");
        addrl.setCreatedDate(new Date());
        addrl.setAddressType(AddressType.POSTAL);
        addrl.setAddressLine2("P.o Box 77684");
        addrl.setArea("Mpangeni");
        addrl.setCode("3880");
        addrl.setStreet("Bhubhesi");

        employee6.addAddress(addrk);
        employee6.addAddress(addrl);

        employeeRepository.save(employee6);

    }

}
