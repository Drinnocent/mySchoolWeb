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
import za.gov.dk.domain.Facility;
import za.gov.dk.domain.School;
import za.gov.dk.service.FacilityServiceLocal;
import za.gov.dk.service.SchoolServiceLocal;


/**
 *
 * @author S2028389
 */
@ManagedBean
@ViewScoped
public class FacilityBean extends BaseBean {

    @Autowired
    private FacilityServiceLocal facilityService;
    @Autowired
    private SchoolServiceLocal schoolService;



    private List<Facility> facilities = new ArrayList<>();
    
    private Facility facility;
    private School school;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        facilities = facilityService.listAll();
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
    }

    public void addOrUpdate(Facility fac) {
        this.resetView(false).setAdd(true);
        if (fac != null) {
           fac.setUpdatedBy(getActiveUser().getIdentifier());
            fac.setUpdatedDate(new Date());
            facility = fac;
        } else {
            facility = new Facility();
             facility.setCreatedBy(getActiveUser().getIdentifier());
            facility.setCreatedDate(new Date());

            facilities.add(0, facility);
        }
    }

    public void save(Facility fac) {
        if (fac.getId() != null) {
            facilityService.update(fac);
        } else {
            facilityService.save(fac);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Facility fac) {
        facilityService.deleteById(fac.getId());
        synchronize(fac);
        this.resetView(false).setList(true);
    }

    public void synchronize(Facility emp) {
        Iterator<Facility> facilityList = facilities.iterator();
        while (facilityList.hasNext()) {
            if (facilityList.next().getId().equals(emp.getId())) {
                facilityList.remove();
            }
        }
    }

    public void cancel(Facility fac) {
        if (fac.getId() == null) {
            if (facilities.contains(fac)) {
                facilities.remove(fac);
            }
            this.resetView(false).setList(true);
        }
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

   

}
