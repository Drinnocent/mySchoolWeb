/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2028389
 */
@Entity
@Audited
@Table(name = "assessment")
public class Assessment extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "assess_status")
    private String status;
    @Column(name = "student_Mark")
    private double studentmark;
    @Column(name = "pass_Mark")
    private double passMark;
    @Column(name = "total_Mark")
    private double totalMark;
    @Column(name = "release_Date")
    private Date releaseDate;
    @Column(name = "due_date")
    private Date dueDate;
    @Column(name = "submission_Date")
    private Date submissionDate;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Subject subject;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Student student;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Grade grade;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Facility facility;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Employee educator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getStudentmark() {
        return studentmark;
    }

    public void setStudentmark(double studentmark) {
        this.studentmark = studentmark;
    }

    public double getPassMark() {
        return passMark;
    }

    public void setPassMark(double passMark) {
        this.passMark = passMark;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Employee getEducator() {
        return educator;
    }

    public void setEducator(Employee educator) {
        this.educator = educator;
    }
}
