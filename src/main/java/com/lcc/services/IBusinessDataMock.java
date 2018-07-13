package com.lcc.services;

import java.util.List;

import com.lcc.models.Business;

public interface IBusinessDataMock {
	Business addOne(Business business);
	public Business findOne(long id);
	public List<Business> getBusinessList();
	public Object[] getBusinessArray();
}
