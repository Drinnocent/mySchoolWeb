/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author S2028389
 */
@WebListener
public class CustomerServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();

        servletContext.setInitParameter("BootsFaces_THEME", "default");
        servletContext.setInitParameter("BootsFaces_USETHEME", "cerulean");
        servletContext.setInitParameter("primefaces.UPLOADER", "commons");
        servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");
        servletContext.setInitParameter("primefaces.THEME", "nova-light");

        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");

        servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE", "true");

        servletContext.setInitParameter("com.sun.faces.numberOfViewsInSession", "3");

        servletContext.setInitParameter("com.sun.faces.numberOfLogicalViews", "10");
        //servletContext.addFilter("fileUploadFilter", new FileUploadFilter());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
