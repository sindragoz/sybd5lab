/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import control.BalanceChangeServ;
import control.BalanceServ;
import control.ChangeTypeServ;
import control.FamilyMemberServ;
import control.FamilyServ;
import entities.Balance;
import entities.BalanceChange;
import entities.ChangeType;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.DbManager;

/**
 *
 * @author Администратор
 */
public class DSbModel {
 //   private BalanceServ b = new BalanceServ();
    private BalanceChangeServ bc = new BalanceChangeServ();
    private ChangeTypeServ ct = new ChangeTypeServ();
 //   private FamilyMemberServ fm = new FamilyMemberServ();
  //  private FamilyServ f = new FamilyServ();
    
    private DbManager dbManager = null;

    public DSbModel() {
    }

    public DSbModel(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void setDbManager(DbManager dbManager) {
        this.dbManager = dbManager;
        bc.setManager(dbManager);
        ct.setManager(dbManager);
    }
    
    public void addcb(BalanceChange entity) throws SQLException{
        
        bc.add(entity);
    }
    public void addct(ChangeType entity1) throws SQLException{
        ct.add(entity1);
       
    }
    
    public void updatect(ChangeType entity1) throws SQLException{
        ct.update(entity1);
        
    }
    public void updatebc(BalanceChange entity) throws SQLException{
      
        bc.update(entity);
    }
    
    public void deletect(ChangeType entity1) {
        
        ct.delete(entity1);
       
    }
     public void deletebc(BalanceChange entity) {
        try {
            bc.delete(entity);
        } catch (SQLException ex) {
            Logger.getLogger(DSbModel.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
    
    public List<BalanceChange> getBcs() throws SQLException{
        return bc.all();
    }
    
    public List<ChangeType> getCts() throws SQLException{
        return ct.all();
    }
}
