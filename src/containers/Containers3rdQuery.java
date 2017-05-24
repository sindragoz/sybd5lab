/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import entities.IEntity;
import java.sql.Date;

/**
 *
 * @author Администратор
 */
public class Containers3rdQuery implements IEntity{
    private String date;
   private String fname;
   private int memberscnt;
   private int amount;

    public Containers3rdQuery() {
    }
 public int getAmount() {
        return amount;
    }
 public void setAmount(int a) {
        amount = a;
    }
 public int getMemberscnt() {
        return memberscnt;
    }
 public void setMemberscnt(int m) {
        memberscnt = m;
    }
 public String getFname(){
 return fname;
 }
 public void setFname(String n){
     fname=n;
 
 }
  public String getDate(){
 return date;
 }
 public void setDate(String d){
     date=d;
 }
   
    
    @Override
    public String[] getHeader() {
        return new String[] {"fname", "count_members", "amount",
                                "b_date"};
    }

    @Override
    public String[] getRow() {
        return new String[] {fname , memberscnt+"" ,amount+"", date};
    }
}
