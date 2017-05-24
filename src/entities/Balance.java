/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Sindragoz
 */
public class Balance implements IEntity{
  private long id;
  private long f_id;
    private int amount;
    private String date;
     private String fname;
    public Balance(){}

    public Balance(long id,long f_id, int amount, String date,String fname) {
        this.id = id;
        this.f_id=f_id;
        this.amount = amount;
        this.date = date;
        this.fname=fname;
    }

    
    public String getFname(){
return fname;
}
public void setFname(String fn){
this.fname=fn;
}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getF_id(){
return f_id;
}
public void setF_id(long f_id){
this.f_id=f_id;
}

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public String toString(){
        return id+" "+amount + " " + date.toString();
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","fname","amount","date"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"",fname,amount+"",date.toString()};
    }  
}
