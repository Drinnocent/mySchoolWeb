/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import za.gov.dk.common.EmployeeType;

/**
 *
 * @author S2028389
 */

@Entity
@Audited
@Table(name = "employee")
public class Employee extends Person{
    
    @Column(name = "employeeId")
    private String employeeId;
    @Column(name = "sace_RegNumber")
    private String saceRegNumber;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_grade", joinColumns = {
        @JoinColumn(name = "employee_id")}, inverseJoinColumns = {
        @JoinColumn(name = "grade_id")})
    private List<Grade> grades = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_subject", joinColumns = {
        @JoinColumn(name = "employee_id")}, inverseJoinColumns = {
        @JoinColumn(name = "subject_id")})
    private List<Subject> subjects = new ArrayList<>();
    
    @Enumerated(EnumType.STRING)
    @Column(name="employee_type")
    private EmployeeType employeeType;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private School school;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSaceRegNumber() {
        return saceRegNumber;
    }

    public void setSaceRegNumber(String saceRegNumber) {
        this.saceRegNumber = saceRegNumber;
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

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    
    
}
