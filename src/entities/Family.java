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
public class Family implements IEntity{
   private long id;
   private String name;
   private short membercnt;
public Family(){}
public Family(long id,String name,short membercnt){
this.id=id;
this.name=name;
this.membercnt=membercnt;
}
public long getId(){
return id;
}
public void setId(long id){
this.id=id;
}

public String getName(){
return name;
}
public void setName(String name){
this.name=name;
}
public void setMembercnt(short cnt){
membercnt=cnt;
}
public short getMembercnt(){
return membercnt;
}
@Override
    public String toString(){
        return id+" "+name;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","Name","Members"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"", name,membercnt+""};
    }  
}

