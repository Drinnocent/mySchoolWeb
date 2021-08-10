/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.common;

import com.zaxxer.hikari.HikariDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author S2028389
 */
public class DataSourceUtility {

    public static DataSource getDatasource() {
        HikariDataSource datasource = new HikariDataSource();
        datasource.setInitializationFailTimeout(0);
        datasource.setMaximumPoolSize(5);
        datasource.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
        //datasource.addDataSourceProperty("url","jdbc:sqlserver://LPT323EH//SQLEXPRESS;databaseName=school_DB");
        datasource.addDataSourceProperty("url", "jdbc:sqlserver://ptadvsql18;databaseName=school_DB_DR");

        datasource.addDataSourceProperty("user", "sa");
        datasource.addDataSourceProperty("password", "P@ssw0rd");
        return datasource;
    }

    public static DataSource getDataSourceLookup() {
        try {
            InitialContext initialContext = new InitialContext();
            DataSource datasource = (DataSource) initialContext.lookup("java:/schoolDS");
            return datasource;
        } catch (NamingException ex) {
            Logger.getLogger(DataSourceUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
