/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.dk.domain.Attendance;
import za.gov.dk.persistence.AttendanceRepository;

/**
 *
 * @author S2028389
 */
@Service
public class AttendanceService implements AttendanceServiceLocal{
   @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance findById(Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public Attendance update(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAll() {
        attendanceRepository.deleteAll();
    }

    @Override
    public Attendance deleteById(Long id) {
        Attendance att = findById(id);
        if (att != null) {
            attendanceRepository.deleteById(id);
        }
        return att;
    }

    @Override
    public List<Attendance> findAttendanceByAttendanceNum(String attendanceNum) {
        return attendanceRepository.findAll();
    }

    @Override
    public List<Attendance> listAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public boolean isExist(Attendance attendance) {
        return attendanceRepository.findById(attendance.getId()) != null;
    }

    @Override
    public long count() {
        return attendanceRepository.count();
    }
    
}
