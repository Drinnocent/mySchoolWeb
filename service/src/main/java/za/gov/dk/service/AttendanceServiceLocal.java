/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import za.gov.dk.domain.Attendance;

/**
 *
 * @author S2028389
 */
public interface AttendanceServiceLocal {

    Attendance save(Attendance attendance);

    Attendance findById(Long id);

    Attendance update(Attendance attendance);

    void deleteAll();

    Attendance deleteById(Long id);

    List<Attendance> findAttendanceByAttendanceNum(String attendanceNum);

    List<Attendance> listAll();

    boolean isExist(Attendance attendance);

    long count();
}
