/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Balance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;

/**
 *
 * @author Sindragoz
 */
public class BalanceServ extends AbstractService<Balance> {
     public BalanceServ() {
    }

    public BalanceServ(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Balance entity) throws SQLException {
        String query = "insert into balance values"
                + "(nextval('b_seq')," + entity.getF_id() + ","
                + entity.getAmount() + ","+entity.getDate()+");";
        dbManager.executeQuery(query);
    }

    @Override
    public List<Balance> all() throws SQLException {
        List<Balance> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select b_id,balance.f_id,fname,amount,b_date from balance join family on family.f_id=balance.f_id;");
            
            while(rs.next()){
                Balance entity = new Balance();
                entity.setId(rs.getLong("b_id"));
                entity.setF_id(rs.getLong("f_id"));
                entity.setAmount(rs.getInt("amount"));
                entity.setDate(rs.getString("b_date"));
                entity.setFname(rs.getString("fname"));
                entities.add(entity);  
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Balance entity) throws SQLException {
        String query = "delete from balance where b_id = " + entity.getId();
        dbManager.executeQuery(query);
    }

    @Override
    public void update(Balance entity) throws SQLException {
        String query =
                "update balance set f_id = " + entity.getF_id()+ ","
                + "amount = " + entity.getAmount() + ","
                + "b_date = '" + entity.getDate()+ "' "
                + "where b_id = " + entity.getId()+";";
        dbManager.executeQuery(query);
    }
}
