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
public class BalanceChange implements IEntity {
    private long id;
    private long f_id;
    private String reason;
    private String fname;
    private int amount;
    private String date;
public BalanceChange(){}
public BalanceChange(long id,long f_id,String reason,int amount,String date,String fname){
this.id=id;
this.f_id=f_id;
this.reason=reason;
this.amount=amount;
this.date=date;
this.fname=fname;
}

public long getId(){
return id;
}
public void setId(long id){
this.id=id;
}
public long getF_id(){
return f_id;
}
public void setF_id(long f_id){
this.f_id=f_id;
}

public String getReason(){
return reason;
}
public void setReason(String reason){
this.reason=reason;
}
public String getFname(){
return fname;
}
public void setFname(String fn){
this.fname=fn;
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
        return id+" "+amount + " " +" "+reason+" "+ date.toString();
    }

    @Override
    public String[] getHeader(){
        return new String[] {"bc_id","fname","reason","amount","date"};
    }
    @Override
    public String[] getRow(){
            return new String[] {id+" ",fname,reason,amount+"",date};
    }  
    
}
