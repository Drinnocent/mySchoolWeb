/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.Date;
import za.gov.dk.domain.Attendance;
import za.gov.dk.persistence.AttendanceRepository;
import za.gov.dk.persistence.EmployeeRepository;
import za.gov.dk.persistence.StudentRepository;

/**
 *
 * @author S2028389
 */
public class AttendanceHelper {

    public static void addAttendance(AttendanceRepository attendanceRepository, EmployeeRepository employeeRepository, StudentRepository studentRepository) {
        Attendance attendance1 = new Attendance();
        attendance1.setCreatedBy("Dr");
        attendance1.setCreatedDate(new Date());
        attendance1.setName("Maths Class");
        attendance1.setDescription("Class test");
        attendanceRepository.save(attendance1);

        Attendance attendance2 = new Attendance();
        attendance2.setCreatedBy("Dr");
        attendance2.setCreatedDate(new Date());
        attendance2.setName("Project Management");
        attendance2.setDescription("Class test");
        attendanceRepository.save(attendance2);

        Attendance attendance3 = new Attendance();
        attendance3.setCreatedBy("Dr");
        attendance3.setCreatedDate(new Date());
        attendance3.setName("Project Management");
        attendance3.setDescription("Class test");
        attendanceRepository.save(attendance3);
    }

}


