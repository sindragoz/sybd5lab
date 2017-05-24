/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.FamilyMember;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;

/**
 *
 * @author Sindragoz
 */
public class FamilyMemberServ extends AbstractService<FamilyMember> {
     public FamilyMemberServ() {
    }

    public FamilyMemberServ(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(FamilyMember entity) throws SQLException {
        String query = "insert into FamilyMember values"
                + "(nextval('fm_seq')," + entity.getF_id() + ",'"
                +entity.getSec_name()+"','"
                + entity.getName()
                + "','"+entity.getPatroname()+"','"+
                entity.getStatus()+"');";
        dbManager.executeQuery(query);
    }

    @Override
    public List<FamilyMember> all() throws SQLException {
        List<FamilyMember> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select fm_id,familymember.f_id,fname,f,i,o,status from FamilyMember join family on family.f_id=familymember.f_id;");
            
            while(rs.next()){
                FamilyMember entity = new FamilyMember();
                entity.setId(rs.getLong("fm_id"));
                entity.setF_id(rs.getLong("f_id"));
                entity.setSec_name(rs.getString("f"));
                entity.setName(rs.getString("i"));
                entity.setFname(rs.getString("fname"));
                entity.setPatroname(rs.getString("o"));
                entity.setStatus(rs.getString("Status"));
                entities.add(entity);  
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(FamilyMember entity) throws SQLException {
        String query = "delete from FamilyMember where fm_id = " + entity.getId();
        dbManager.executeQuery(query);
    }

    @Override
    public void update(FamilyMember entity) throws SQLException {
        String query =
                "update FamilyMember set f_id = "
                + entity.getF_id()+ ","
                +"f='"+entity.getSec_name()+"',"
                +"i='"+entity.getName()+"',"
                +"o='"+entity.getPatroname()+"',"
                +"status='"+entity.getStatus() + "' "
                + "where fm_id = " + entity.getId()+";";
        dbManager.executeQuery(query);
    }
}
