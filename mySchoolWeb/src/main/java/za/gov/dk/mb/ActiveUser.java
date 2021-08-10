/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.mb;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import za.gov.dk.common.PersonType;
import za.gov.dk.common.SchoolUserStatus;
import za.gov.dk.common.SchoolUserType;

/**
 *
 * @author S2028389
 */
@ManagedBean
@SessionScoped
public class ActiveUser implements Serializable{
    
    private String username;
    private StringBuilder displayName;
    private boolean menuActivationIndicator = Boolean.TRUE;
    private boolean userLoginIndicator = false;
    private String userRole;
    private boolean templateUploadIndicator;
    private String moduleWelcomeMessage;
    private String adminRole;
    private String userSessionId;
    private String firstName;
    private String lastName;
    private String identifier;
    private boolean learner;
    private boolean admin;
    private boolean educator;
    private boolean principal;
    private boolean clerk;
    private boolean headOfDepartment;
    private boolean generalWorker;
    private boolean systemadmin;
    private SchoolUserStatus activeStatus;
    private PersonType personType;
    private SchoolUserType systemUserType;
    
    public void resetRole(boolean validity)
    {
        setAdmin(validity);
        setClerk(validity);
        setEducator(validity);
        setGeneralWorker(validity);
        setPrincipal(validity);
        setLearner(validity);
        setSystemadmin(validity);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public StringBuilder getDisplayName() {
        return displayName;
    }

    public void setDisplayName(StringBuilder displayName) {
        this.displayName = displayName;
    }

    public boolean isMenuActivationIndicator() {
        return menuActivationIndicator;
    }

    public void setMenuActivationIndicator(boolean menuActivationIndicator) {
        this.menuActivationIndicator = menuActivationIndicator;
    }

    public boolean isUserLoginIndicator() {
        return userLoginIndicator;
    }

    public void setUserLoginIndicator(boolean userLoginIndicator) {
        this.userLoginIndicator = userLoginIndicator;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public boolean isTemplateUploadIndicator() {
        return templateUploadIndicator;
    }

    public void setTemplateUploadIndicator(boolean templateUploadIndicator) {
        this.templateUploadIndicator = templateUploadIndicator;
    }

    public String getModuleWelcomeMessage() {
        return moduleWelcomeMessage;
    }

    public void setModuleWelcomeMessage(String moduleWelcomeMessage) {
        this.moduleWelcomeMessage = moduleWelcomeMessage;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public String getUserSessionId() {
        return userSessionId;
    }

    public void setUserSessionId(String userSessionId) {
        this.userSessionId = userSessionId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public SchoolUserStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(SchoolUserStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

 

    public boolean isLearner() {
        return learner;
    }

    public void setLearner(boolean learner) {
        this.learner = learner;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isEducator() {
        return educator;
    }

    public void setEducator(boolean educator) {
        this.educator = educator;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public boolean isClerk() {
        return clerk;
    }

    public void setClerk(boolean clerk) {
        this.clerk = clerk;
    }

    public boolean isHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(boolean headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public boolean isGeneralWorker() {
        return generalWorker;
    }

    public void setGeneralWorker(boolean generalWorker) {
        this.generalWorker = generalWorker;
    }

    public boolean isSystemadmin() {
        return systemadmin;
    }

    public void setSystemadmin(boolean systemadmin) {
        this.systemadmin = systemadmin;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public SchoolUserType getSystemUserType() {
        return systemUserType;
    }

    public void setSystemUserType(SchoolUserType systemUserType) {
        this.systemUserType = systemUserType;
    }
    
    
    
}
