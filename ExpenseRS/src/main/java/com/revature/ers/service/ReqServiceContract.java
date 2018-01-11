/**
 * 
 */
package com.revature.ers.service;

import java.sql.Blob;
import java.util.List;

import com.revature.ers.dto.ReqDto;
import com.revature.ers.model.ReimRequest;

/**
 * @author Mohamed
 *
 */
public interface ReqServiceContract {
	
	
	public boolean submitReq(ReimRequest aReq);

	
	public boolean uploadReqRec(Blob aFile, int reqId);
	
	
	public Blob downloadRec(int reqId);
	
	public List<ReqDto> getAllReqbyUser(int userId);
	
	public List<ReqDto> getAllPendingReqsByUser(int userId);
	
	public List<ReqDto> getAllResolvedReqsByUser(int userId);
	
	public List<ReqDto> getAllPendingReqs();
	
	public List<ReqDto> getAllResolvedReqs();
	
	
	public boolean updateReqManager(int mangId, int statusId, int reqId);
	
	
	
	
}
