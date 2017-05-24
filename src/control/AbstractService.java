/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import manager.DbManager;

/**
 *
 * @author Regener
 */
public abstract class AbstractService<T> {
    protected DbManager dbManager;

    public AbstractService() {
    }

    public AbstractService(DbManager dbManager) {
        this.dbManager = dbManager;
    }
            
    public abstract void add(T entity) throws SQLException;
    public abstract List<T> all() throws SQLException;
    public abstract void delete(T entity) throws SQLException;
    public abstract void update(T entity) throws SQLException;
    
    public void setManager(DbManager dbManager){
        this.dbManager = dbManager;
    }
}
