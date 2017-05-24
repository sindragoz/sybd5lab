/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import entities.IEntity;

/**
 *
 * @author Администратор
 */
public class Container1stQuery implements IEntity{
    private int amount;
    private String reason;
    private int type;

    public Container1stQuery() {
    }

    public Container1stQuery(String r, int a,int t) {
       amount=a;
       reason=r;
       type=t;
       
    }

    public int getAmount() {
        return amount;
    }
    public String getReason() {
        return reason;
    }
    public int getType() {
        return type;
    }
public void setAmount(int a) {
        amount = a;
    }
    public void setReason(String r) {
        reason = r;
    }
     
      public void setType(int t) {
        type =t;
    }

    @Override
    public String[] getHeader() {
        return new String[] {"amount", "reason", "type"};
    }

    @Override
    public String[] getRow() {
        return new String[] {amount+"" , reason ,type+""};
    }
}
