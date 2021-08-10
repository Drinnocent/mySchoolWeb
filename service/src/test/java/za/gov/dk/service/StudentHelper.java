/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.Date;
import za.gov.dk.common.AddressType;
import za.gov.dk.common.Gender;
import za.gov.dk.common.PersonType;
import za.gov.dk.domain.Address;
import za.gov.dk.domain.ContactDetail;
import za.gov.dk.domain.Student;
import za.gov.dk.persistence.GradeRepository;
import za.gov.dk.persistence.SchoolRepository;
import za.gov.dk.persistence.StudentRepository;
import za.gov.dk.persistence.SubjectRepository;

/**
 *
 * @author S2028389
 */
public class StudentHelper {

    public static void addStudent(StudentRepository studentRepository, SchoolRepository schoolRepository, GradeRepository gradeRepository, SubjectRepository subjectRepository) {
        Student student1 = new Student();

        student1.setCreatedBy("Samkelo");
        student1.setCreatedDate(new Date());
        student1.setFirstName("Akhona");
        student1.setLastName("Khanyile");
        student1.setIdentityNumber("198702106394087");
        student1.setStudentNumber("217001326");
        student1.setPersonType(PersonType.LEARNER);
        student1.setGenderType(Gender.MALE);
        student1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student1.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 1));
        student1.setSubjects(subjectRepository.findAll());

        ContactDetail contact1 = new ContactDetail();
        contact1.setCreatedBy("Abelo");
        contact1.setCreatedDate(new Date());
        contact1.setCellphone_number("0685541774");
        contact1.setEmailAddress("dco@");
        contact1.setTellphone_number("031412547");
        student1.setContactDetail(contact1);

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

        student1.addAddress(addr1);
        student1.addAddress(addr2);

        studentRepository.save(student1);

        Student student2 = new Student();

        student2.setCreatedBy("Lethu");
        student2.setCreatedDate(new Date());
        student2.setFirstName("Micasa");
        student2.setLastName("Madondo");
        student2.setIdentityNumber("000702106394087");
        student2.setStudentNumber("218001326");
        student2.setPersonType(PersonType.LEARNER);
        student2.setGenderType(Gender.FEMALE);
        student2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student2.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 1));
        student2.setSubjects(subjectRepository.findAll());

        ContactDetail contact2 = new ContactDetail();
        contact2.setCreatedBy("Aphiwe");
        contact2.setCreatedDate(new Date());
        contact2.setCellphone_number("0784441774");
        contact2.setEmailAddress("dco@");
        contact2.setTellphone_number("031812547");
        student2.setContactDetail(contact2);

        Address addrc = new Address();
        addrc.setCreatedBy("Lizy");
        addrc.setCreatedDate(new Date());
        addrc.setAddressType(AddressType.RESIDENTIAL);
        addrc.setAddressLine1("Victoria 165");
        addrc.setArea("Durban");
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

        student2.addAddress(addrc);
        student2.addAddress(addrd);

        studentRepository.save(student2);

        Student student3 = new Student();

        student3.setCreatedBy("Noble");
        student3.setCreatedDate(new Date());
        student3.setFirstName("Neliswa");
        student3.setLastName("Zungu");
        student3.setIdentityNumber("98702106394087");
        student3.setStudentNumber("219001326");
        student3.setPersonType(PersonType.LEARNER);
        student3.setGenderType(Gender.FEMALE);
        student3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student3.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 1));
        student3.setSubjects(subjectRepository.findAll());

        ContactDetail contact3 = new ContactDetail();
        contact3.setCreatedBy("Test");
        contact3.setCreatedDate(new Date());
        contact3.setCellphone_number("0784441774");
        contact3.setEmailAddress("dco@");
        contact3.setTellphone_number("031812547");
        student3.setContactDetail(contact3);

        Address addre = new Address();
        addre.setCreatedBy("Leah");
        addre.setCreatedDate(new Date());
        addre.setAddressType(AddressType.RESIDENTIAL);
        addre.setAddressLine1("NewCastle");
        addre.setArea("Mbali");
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

        student3.addAddress(addre);
        student3.addAddress(addrf);

        studentRepository.save(student3);

        Student student4 = new Student();

        student4.setCreatedBy("Noble");
        student4.setCreatedDate(new Date());
        student4.setFirstName("Neliswa");
        student4.setLastName("Zungu");
        student4.setIdentityNumber("98702106394087");
        student4.setStudentNumber("212001326");
        student4.setPersonType(PersonType.LEARNER);
        student4.setGenderType(Gender.MALE);
        student4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student4.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 1));
        student4.setSubjects(subjectRepository.findAll());

        ContactDetail contact4 = new ContactDetail();
        contact4.setCreatedBy("Lelo");
        contact4.setCreatedDate(new Date());
        contact4.setCellphone_number("0784441774");
        contact4.setEmailAddress("dco@");
        contact4.setTellphone_number("031812547");
        student4.setContactDetail(contact4);

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

        student4.addAddress(addrg);
        student4.addAddress(addrh);

        studentRepository.save(student4);
    }

}
