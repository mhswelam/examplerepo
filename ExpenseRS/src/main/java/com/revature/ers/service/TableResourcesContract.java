/**
 * 
 */
package com.revature.ers.service;

import java.util.List;

import com.revature.ers.model.ReqStatus;
import com.revature.ers.model.Reqtype;
import com.revature.ers.model.UserRole;

/**
 * @author Mohamed
 *
 */
public interface TableResourcesContract {
	
	
	
	public String getUserRole(int roleId);
	
	public String getReqType(int typeId);
	
	public String getReqStatus(int statusId);
	
	public int getUserRoleId(String role);
	
	public int getReqTypeId(String type);
	
	public int getReqStatusId(String aStatus);
	
	public List<UserRole> getUserRoleList();
	
	public List<Reqtype> getReqTypeList();
	
	public List<ReqStatus> getReqStatusList();
	

}
