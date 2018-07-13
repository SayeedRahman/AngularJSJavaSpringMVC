package com.lcc.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import com.lcc.models.Business;


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BusinessDataMock implements IBusinessDataMock {
	private List<Business> businessList = new ArrayList<Business>();
	
	public BusinessDataMock() {
		Long cId = (long) 0;
		Business business = new Business(cId, "123 Any Street", new Date().toString(), "email1@gmail.com", "Business Name One",  "6136136134", "www.example1.com");
		businessList.add(business);
		
		cId = (long) 1;
		business = new Business(cId, "234 Any Street", new Date().toString(), "email2@gmail.com", "Business Name Two", "6136146144", "www.example2.com");
		businessList.add(business);	
				
		cId = (long) 2;
		business = new Business(cId, "345 Any Street", new Date().toString(), "email3@gmail.com", "Business Name Three", "6136156145", "www.example3.com");
		businessList.add(business);	
		
		cId = (long) 3;
		business = new Business(cId, "456 Any Street", new Date().toString(), "email4@gmail.com", "Business Name Four", "6136166145", "www.example4.com");
		businessList.add(business);	
		
		cId = (long) 4;
		business = new Business(cId, "567 Any Street", new Date().toString(), "email5@gmail.com", "Business Name Five", "6136176145", "www.example5.com");
		businessList.add(business);	
	}
	
	@Override
	public Business addOne(Business business){
		if( business != null && this.businessList.add(business)) {
			return business;
		}
		return null;
	}
	
	@Override
	public Business findOne(long id){
		if(id > -1 && id < businessList.size()) {
			return this.businessList.get((int)id);
		}
		return null;
	}
	
	@Override
	public List<Business> getBusinessList(){
		return this.businessList;
	}
	
	@Override
	public Object[] getBusinessArray(){
		return this.businessList.toArray();
	}
}
