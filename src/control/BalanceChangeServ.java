/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.BalanceChange;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;

/**
 *
 * @author Sindragoz
 */
public class BalanceChangeServ extends AbstractService<BalanceChange> {
     public BalanceChangeServ() {
    }

    public BalanceChangeServ(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(BalanceChange entity) throws SQLException {
        String query = "insert into BalanceChange values"
                + "(nextval('bc_seq')," + entity.getF_id() + ",'"
                +entity.getReason()+"',"
                + entity.getAmount()
                + ","+entity.getDate()+");";
        dbManager.executeQuery(query);
    }

    @Override
    public List<BalanceChange> all() throws SQLException {
        List<BalanceChange> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select bc_id,balancechange.f_id,fname,reason,amount,bc_date from BalanceChange join family on family.f_id=balancechange.f_id;");
            
            while(rs.next()){
                BalanceChange entity = new BalanceChange();
                entity.setId(rs.getLong("bc_id"));
                entity.setF_id(rs.getLong("f_id"));
                entity.setFname(rs.getString("fname"));
                 entity.setReason(rs.getString("reason"));
                entity.setAmount(rs.getInt("amount"));
                entity.setDate(rs.getString("bc_date"));
                entities.add(entity);  
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(BalanceChange entity) throws SQLException {
        String query = "delete from BalanceChange where bc_id = " + entity.getId();
        dbManager.executeQuery(query);
    }

    @Override
    public void update(BalanceChange entity) {
        String query =
                "update balancechange set f_id = "
                + entity.getF_id()+ ","
                +"reason='"+entity.getReason()+"',"
                + "amount = " + entity.getAmount() + ","
                + "bc_date = '" + entity.getDate()+ "' "
                + "where bc_id = " + entity.getId()+";";
        System.out.print(entity.getId()+" "+entity.getF_id()+" "+entity.getReason()+" "+entity.getAmount()+" "+entity.getDate()+" ");
        dbManager.executeQuery(query);
    }
}
