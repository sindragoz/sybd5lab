/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import containers.ConnectionContainer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Regener
 */
public class DbManager {
    private ConnectionContainer conCont;
    private Connection connection = null;
    private Statement statement = null;

    public void setConnectionContainer(ConnectionContainer conCont) {
        this.conCont = conCont;
    }
    
    public boolean openConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(conCont.getUrl(), conCont.getName(), conCont.getPassword());
            statement = connection.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null,
                    ex);
            return false;
        }
    }
    
    public boolean closeConnection(){
        if (connection != null) {
                try {
                    connection.close(); // Каскадное закрытие statement, resultSet
                    
                } catch (SQLException ex) {
                    Logger.getLogger(DbManager.class.getName()).log(
                            Level.SEVERE,
                            null, ex);
                    return false;
                }
            }
        return true;
    }
    
    public ResultSet executeQuery(String query) {
        if(statement != null){
            try {
                return statement.executeQuery(query);
            } catch (Exception ex) {
               
            }   
        }
        return null;

    }
}
