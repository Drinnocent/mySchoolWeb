/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.dk.domain.Employee;
import za.gov.dk.domain.School;
import za.gov.dk.domain.Subject;
import za.gov.dk.service.EmployeeServiceLocal;
import za.gov.dk.service.SchoolServiceLocal;
import za.gov.dk.service.SubjectServiceLocal;

/**
 *
 * @author S2028389
 */
@ManagedBean
@ViewScoped
public class SubjectBean extends BaseBean {

    @Autowired
    private SubjectServiceLocal subjectService;
    @Autowired
    private SchoolServiceLocal schoolService;
   
    private List<Subject> subjects = new ArrayList<>();
    private List<Employee> ed=new ArrayList<>();
   

    private Subject subject;
    private School school;
    private Employee educator;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);

        subjects = subjectService.listAll();
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);

    }

    public void addOrUpdate(Subject sub) {
        this.resetView(false).setAdd(true);
        if (sub != null) {
             sub.setUpdatedBy(getActiveUser().getIdentifier());
            sub.setUpdatedDate(new Date());
            subject = sub;
        } else {
            subject = new Subject();
            subject.setCreatedBy(getActiveUser().getIdentifier());
            subject.setCreatedDate(new Date());

            subjects.add(0, subject);
        }
    }

    public void save(Subject sub) {
        if (sub.getId() != null) {
            subjectService.update(sub);
        } else {
            subjectService.save(sub);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Subject sub) {
        subjectService.deleteById(sub.getId());
        synchronize(sub);
        this.resetView(false).setList(true);
    }

    public void synchronize(Subject sub) {
        Iterator<Subject> subjectList = subjects.iterator();
        while (subjectList.hasNext()) {
            if (subjectList.next().getId().equals(sub.getId())) {
                subjectList.remove();
            }
        }
    }

    public void cancel(Subject sub) {
        if (sub.getId() == null) {
            if (subjects.contains(sub)) {
                subjects.remove(sub);
            }
            this.resetView(false).setList(true);
        }
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Employee getEducator() {
        return educator;
    }

    public void setEducator(Employee educator) {
        this.educator = educator;
    } 
}