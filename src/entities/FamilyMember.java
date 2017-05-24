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
public class FamilyMember implements IEntity{
    private long id;
    private long f_id;
    private String sec_name;
    private String name;
    private String patroname;
    private String status;
    private String fname;
    

    public FamilyMember(){}
    public FamilyMember(long id,long f_id,String sec_name,String name,String patroname,String status){
    this.id=id;
    this.f_id=f_id;
    this.sec_name=sec_name;
    this.name=name;
    this.patroname=patroname;
    this.status=status;
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
public String getSec_name(){
return sec_name;
}
public void setSec_name(String sn){
this.sec_name=sn;
}
public String getName(){
return name;
}
public void setName(String n){
this.name=n;
}
public String getPatroname(){
return patroname;
}
public void setPatroname(String pn){
this.patroname=pn;
}
public String getStatus(){
return status;
}
public void setStatus(String st){
this.status=st;
}
@Override
    public String toString(){
        return id+" "+sec_name + " " + name+" "+ status;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","fname","Second_name","Name","Patroname","Status"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"",fname,sec_name,name,patroname,status};
    }  

    
}
