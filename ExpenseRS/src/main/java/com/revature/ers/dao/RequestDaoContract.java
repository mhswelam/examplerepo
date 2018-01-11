/**
 * 
 */
package com.revature.ers.dao;

import java.io.File;
import java.util.List;

import com.revature.ers.model.ReimRequest;

/**
 * @author Mohamed
 *
 */
public interface RequestDaoContract {
	
	
	public boolean insertRequest(ReimRequest arequest);
	
	
	
	public boolean updateRequestReceipt(int reqId, File afile);
	
	
	
	public boolean updateReqStatus(int reqId, int aStatus, int resId);
	
	
	public List<ReimRequest> getAllReqResolvedForUser(int userId);
	
	public List<ReimRequest> getAllReqPendingForUser(int userId);
	
	public List<ReimRequest> getAllReqByUser(int userId);
	
	public List<ReimRequest> getAllReqResolved();
	
	public List<ReimRequest> getAllReqPending();
	
	
	
	

	
	
	
	
	
	
	
	

}
