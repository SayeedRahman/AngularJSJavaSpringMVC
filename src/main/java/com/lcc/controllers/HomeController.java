package com.lcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lcc.models.Business;
import com.lcc.services.BusinessDataMock;

@Controller
public class HomeController {
	
	@Autowired
	BusinessDataMock dao;

	@RequestMapping("/")
	public String index() {
		return "index.html";
	}

  	@RequestMapping(value="/getBusinesses", method=RequestMethod.GET)
	public ResponseEntity<List<Business>> getBusinesses() {
  		return new ResponseEntity<List<Business>>(dao.getBusinessList(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getBusiness/{id}", method=RequestMethod.GET)
	public ResponseEntity<Business> getBusiness(@PathVariable("id") int businessId) {
		return new ResponseEntity<Business>(dao.findOne(businessId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getDetails", method=RequestMethod.POST)
	public ResponseEntity<Business> getDetails(@RequestBody Business business) {
		return new ResponseEntity<Business>(business, HttpStatus.OK);
	}	
}