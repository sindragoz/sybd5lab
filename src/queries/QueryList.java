/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import containers.Container1;
import containers.Container2;
import containers.Containers3;
import entities.IEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.DbManager;

/**
 *
 * @author Администратор
 */
public class QueryList {
    private DbManager dbManager;

    public QueryList() {
    }

    public QueryList(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void setDbManager(DbManager dbManager) {
        this.dbManager = dbManager;
    }
    
    public List<IEntity> query1() throws SQLException{
        List<IEntity> queryres = null;
        try {
            queryres = new ArrayList<>();
            String query = "select amount,reason,ctype from balancechange join changetype on balancechange.bc_id=changetype.bc_id and changetype.ctype=-1;";
            ResultSet rs = dbManager.executeQuery(query);
            while(rs.next()){
                Container1 c = new Container1();
                c.setAmount(rs.getInt("amount"));
                c.setReason(rs.getString("reason"));
                c.setType(rs.getInt("ctype"));
                
                queryres.add(c);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return queryres;
    }
    
    public List<IEntity> query2() throws SQLException{
       List<IEntity> queryres = null;
        try {
            queryres = new ArrayList<>();
            String query = "select amount,reason,ctype from balancechange join changetype on balancechange.bc_id=changetype.bc_id and changetype.ctype=1;";
            ResultSet rs = dbManager.executeQuery(query);
            while(rs.next()){
                Container2 c = new Container2();
                c.setAmount(rs.getInt("amount"));
                c.setReason(rs.getString("reason"));
                c.setType(rs.getInt("ctype"));
                
                queryres.add(c);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return queryres;
    }
    
    public List<IEntity> query3() throws SQLException{
        List<IEntity> queryres = null;
        try {
            queryres = new ArrayList<>();
            String query = " select fname,count_members,amount,b_date from family join balance on family.f_id=balance.f_id and balance.amount>30000;";
            ResultSet rs = dbManager.executeQuery(query);
            while(rs.next()){
                Containers3 c = new Containers3();
                c.setAmount(rs.getInt("amount"));
                c.setMemberscnt(rs.getInt("count_members"));
                c.setFname(rs.getString("fname"));
                c.setDate(rs.getString("b_date"));       
                queryres.add(c);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return queryres;
    }
}
