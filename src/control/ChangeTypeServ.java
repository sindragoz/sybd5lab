/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.ChangeType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;

/**
 *
 * @author Sindragoz
 */
public class ChangeTypeServ extends AbstractService<ChangeType> {
     public ChangeTypeServ() {
    }

    public ChangeTypeServ(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(ChangeType entity){
        String query = "insert into ChangeType values"
                + "(nextval('ct_seq')," + entity.getBc_id() + ","
                + entity.getType()+");";
        dbManager.executeQuery(query);
    }

    @Override
    public List<ChangeType> all() throws SQLException {
        List<ChangeType> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select ct_id,balancechange.bc_id,amount,ctype from ChangeType join balancechange on changetype.bc_id=balancechange.bc_id;");
            
            while(rs.next()){
                ChangeType entity = new ChangeType();
                entity.setId(rs.getLong("ct_id"));
                entity.setBc_id(rs.getLong("bc_id"));
                entity.setType(rs.getInt("ctype"));
                entity.setAmount(rs.getInt("amount"));
                entities.add(entity);  
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(ChangeType entity){
        long bc_id=entity.getBc_id();
        String query = "delete from ChangeType where ct_id = " + entity.getId();
        dbManager.executeQuery(query);
    }

    @Override
    public void update(ChangeType entity) throws SQLException {
        String query =
                "update ChangeType set bc_id = " + entity.getBc_id()+ ","
                + "ctype = " + entity.getType() + " "
                + "where ct_id = " + entity.getId()+";";
        dbManager.executeQuery(query);
    }
}
