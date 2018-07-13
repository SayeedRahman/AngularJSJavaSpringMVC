package com.lcc.models;

import java.io.Serializable;
import java.util.Date;

public class Business implements Serializable {

	private static final long serialVersionUID = 1L;
	private  Long businessId = (long)0;
    private  String address = "";
    private  String date = new Date().toString();
    private  String email = "";
    private  String name = "";
    private  String telephone = "";
    private  String url = "";
    public Business(){};
    public Business(Long bId, String addr, String d, String e, String n, String t, String u){
    	businessId = bId;
        address = addr;
        date = d;
        email = e;
        name = n;
        telephone = t;
        url = u;
    }
    
    public String getAddress(){
    	return address;
    }
    public void setAddress(String a){
    	address = a;
    }
     
    public Long getBusinessId(){
    	return businessId;
    }
    public void setBusinessId(Long id){
    	businessId = id;
    }
    
    public String getDate(){
    	return date;
    }
    public void setDate(String d){
    	date = d;
    } 
      
    public String getEmail(){
    	return email;
    }
    public void setEmail(String e){
    	email = e;
    }
    
    public String getName(){
    	return name;
    }
    public void setName(String fName){
    	name = fName;
    }   
    
    public String getTelephone(){
    	return telephone;
    }
    public void setTelephone(String t){
    	telephone = t;
    }
    
    public String getUrl(){
    	return url;
    }
    public void setUrl(String u){
    	url = u;
    }
}