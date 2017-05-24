/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Sindragoz
 */
public class ChangeType implements IEntity {
    private long id;
    private long bc_id;
    private int type;
    private int amount;
    public ChangeType(){}
    public ChangeType(long id,long bc_id,int type,int amount){
    this.id=id;
    this.bc_id=bc_id;
    this.type=type;
    this.amount=amount;
    }
     public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getBc_id(){
return bc_id;
}
public void setBc_id(long bc_id){
this.bc_id=bc_id;
}
public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
     @Override
    public String toString(){
        return id+" "+type+" "+amount;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","amount","type"};
    }
    @Override
    public String[] getRow(){
       
        return new String[] {id+"",amount+"",type+""};
    }  
   
}
