package com.APIATTENDANCE.application.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APIATTENDANCE.application.entity.Company;
import com.APIATTENDANCE.application.entity.format.JsonFormat;
import com.APIATTENDANCE.application.repository.CompanyRepository;
import com.APIATTENDANCE.application.util.UtilMess;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyServer;
	
	public List<Company> GetAll(){
		List<Company> lstCom = companyServer.findAll();

		for(int i = 0; i < lstCom.size(); i++) {
			lstCom.get(i).setPlace(null);
			lstCom.get(i).setUser(null);
			lstCom.get(i).setUserFrequency(null);
		}
		return lstCom;
	}
	
	public Object GetComUsingProvice(Company com) {
		try {
			List<Company> lstCom = companyServer.GetComByProvinceID(com.getCom_province());
			for(int i = 0; i < lstCom.size(); i++) {
				lstCom.get(i).setPlace(null);
				lstCom.get(i).setUser(null);
				lstCom.get(i).setUserFrequency(null);
			}
			if(lstCom.size()==0) throw new NullPointerException();
			return lstCom;
		} catch (Exception e) {
			return JsonFormat.message(false, "not found company");
		}
	}
	
}
