/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author S2028389
 */
@ManagedBean
@RequestScope
public class MenuBean extends BaseBean {

    @PostConstruct
    public void init() {
        String page = "";
    }

    public String route(String page) {
        return defaultRouter(page);
    }

    public String routing(String page) {
        return defaultRouter(page);
    }

    public String routeToAdmin(String page) {
        getActiveUser().setModuleWelcomeMessage("Welcome to Admin");
        return defaultRouter(page);
    }

    public String routeToEmployee(String page) {
        getActiveUser().setModuleWelcomeMessage("Welcome to Employee");
        return defaultRouter(page);
    }

    public String routeToLearner(String page) {
        getActiveUser().setModuleWelcomeMessage("Welcome to Learner");
        return defaultRouter(page);
    }

}
