/**
 * 
 */
package com.revature.ers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.revature.ers.dao.EresourcesDao;
import com.revature.ers.model.ReqStatus;
import com.revature.ers.model.Reqtype;
import com.revature.ers.model.UserRole;

/**
 * @author Mohamed
 *
 */
public class TableService implements TableResourcesContract {
	
	
	private EresourcesDao resourceDao = new EresourcesDao();
	
	private Map<Integer,UserRole> roleMap = resourceDao.getUserRoles();
	
	private Map<Integer,Reqtype> typeMap = resourceDao.getrType();
	
	private Map<Integer,ReqStatus> statusMap = resourceDao.getrStatus();
	
	
	public TableService() {
		
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.TableResourcesContract#getUserRole(int)
	 */
	@Override
	public String getUserRole(int roleId) {
		
		return (roleMap.get(roleId)).getName();
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.TableResourcesContract#getReqType(int)
	 */
	@Override
	public String getReqType(int typeId) {
		
		return (typeMap.get(typeId)).getName();
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.TableResourcesContract#getReqStatus(int)
	 */
	@Override
	public String getReqStatus(int statusId) {
		
		return (statusMap.get(statusId)).getName();
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.TableResourcesContract#getUserRoleId(java.lang.String)
	 */
	@Override
	public int getUserRoleId(String role) {
		int result = 0;
		for(UserRole aRole : getUserRoleList()) {
			if (aRole.getName().equals(role)) {
				result = aRole.getId();
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.TableResourcesContract#getReqTypeId(java.lang.String)
	 */
	@Override
	public int getReqTypeId(String type) {
		int result = 0;
		for(Reqtype aType : getReqTypeList()) {
			if (aType.getName().equals(type)) {
				result = aType.getId();
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.TableResourcesContract#getReqStatusId(java.lang.String)
	 */
	@Override
	public int getReqStatusId(String aStatus) {
		int result = 0;
		for(ReqStatus aStat : getReqStatusList()) {
			if (aStat.getName().equals(aStatus)) {
				result = aStat.getId();
			}
		}
		return result;
	}

	@Override
	public List<UserRole> getUserRoleList() {
		List<UserRole> result = new ArrayList<>();
		for(UserRole aRole : roleMap.values() ) {
			result.add(aRole);
		}
		return result;
	}

	@Override
	public List<Reqtype> getReqTypeList() {
		List<Reqtype> result = new ArrayList<>();
		for(Reqtype aType : typeMap.values() ) {
			result.add(aType);
		}
		return result;
	}

	@Override
	public List<ReqStatus> getReqStatusList() {
		List<ReqStatus> result = new ArrayList<>();
		for(ReqStatus aStatus : statusMap.values() ) {
			result.add(aStatus);
		}
		return result;
	}

}
