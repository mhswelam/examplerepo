package com.revature.ers.dao;

import java.util.Map;

import com.revature.ers.model.ReqStatus;
import com.revature.ers.model.Reqtype;
import com.revature.ers.model.UserRole;

public interface EresourcesDaoContract {
	
	
	
	
	
	public Map<Integer, UserRole> getUserRoles();
	
	public Map<Integer, ReqStatus> getrStatus();
	
	public Map<Integer, Reqtype> getrType();

}
