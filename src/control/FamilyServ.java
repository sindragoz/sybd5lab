/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Family;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;

/**
 *
 * @author Sindragoz
 */
public class FamilyServ extends AbstractService<Family> {
     public FamilyServ() {
    }

    public FamilyServ(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Family entity) throws SQLException {
        String query = "insert into Family values"
                + "(nextval('f_seq'),'" + entity.getName() + "',"
                +entity.getMembercnt()+");";
        dbManager.executeQuery(query);
    }

    @Override
    public List<Family> all() throws SQLException {
        List<Family> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from Family");
            
            while(rs.next()){
                Family entity = new Family();
                entity.setId(rs.getLong("f_id"));
                entity.setName(rs.getString("fname"));
                entity.setMembercnt(rs.getShort("count_members"));
                entities.add(entity);  
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Family entity) throws SQLException {
        String query = "delete from Family where f_id = " + entity.getId();
        dbManager.executeQuery(query);
    }

    @Override
    public void update(Family entity) throws SQLException {
        String query =
                "update Family set fname = '"
                + entity.getName()+ "',"
                +"count_members="+entity.getMembercnt()+" "
                + "where f_id = " + entity.getId()+";";
        dbManager.executeQuery(query);
    }
}
