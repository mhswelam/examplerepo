/**
 * 
 */
package com.revature.ers.service;

import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.revature.ers.dao.RequestDao;
import com.revature.ers.dto.ReqDto;
import com.revature.ers.model.ReimRequest;

/**
 * @author Mohamed
 *
 */
public class ReqService implements ReqServiceContract {
	
	
	private RequestDao myReqDb = new RequestDao();
	private TableService myTables = new TableService();
	private UserService userDb = new UserService();
	final  int pending = 22;
	final int approved = 55;
	final int denied = 66;

	/* (non-Javadoc)
	 * @see com.revature.ers.service.ReqServiceContract#submitReq(com.revature.ers.model.ReimRequest)
	 */
	@Override
	public boolean submitReq(ReimRequest aReq) {
		boolean result = false;
		result = myReqDb.insertRequest(aReq);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.ReqServiceContract#uploadReqRec(java.sql.Blob, int)
	 */
	@Override
	public boolean uploadReqRec(Blob aFile, int reqId) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.ReqServiceContract#downloadRec(int)
	 */
	@Override
	public Blob downloadRec(int reqId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.ReqServiceContract#getAllReqbyUser(int)
	 */
	@Override
	public List<ReqDto> getAllReqbyUser(int userId) {
		List<ReqDto> result = new ArrayList<>();
		String rec = "";
		String resolvedDate = "";
		String manager = "";
		DateFormat datef = new SimpleDateFormat("MM/dd/yyyy");

		for(ReimRequest aReq : myReqDb.getAllReqByUser(userId)) {
			rec = "";
			resolvedDate = "";
			manager = "";
			
			if (aReq.getrReceipt() != null) {
				rec ="Receipt";
			}
			if (aReq.getrResolved() != null) {
				resolvedDate = datef.format(aReq.getrResolved());
			}
			if (aReq.getResolverId() > 0) {
				manager = (userDb.getUser(aReq.getResolverId())).getUserFirst() + " " +
						(userDb.getUser(aReq.getResolverId())).getUserLast();
			}
			 
			result.add(new ReqDto(aReq.getrId(),aReq.getrAmount(),aReq.getrDescription(),
					rec,datef.format(aReq.getrSubmitted()),resolvedDate,
					(userDb.getUser(aReq.getAuthorId())).getUserName(),manager,myTables.getReqType(aReq.getrType()),
					myTables.getReqStatus(aReq.getrStatus())));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.ReqServiceContract#getAllReqbyStatus(int)
	 */
	@Override
	public List<ReqDto> getAllPendingReqs() {
		List<ReqDto> result = new ArrayList<>();
		String rec = " ";
		String resolvedDate = " ";
		String manager = " ";
		DateFormat datef = new SimpleDateFormat("MM/dd/yyyy");

			for(ReimRequest aReq : myReqDb.getAllReqPending()) {
				rec = " ";
				resolvedDate = " ";
				manager = " ";
				
				if (aReq.getrReceipt() != null) {
					rec ="Receipt";
				}
				if (aReq.getrResolved() != null) {
					resolvedDate = datef.format(aReq.getrResolved());
				}
				if (aReq.getResolverId() > 0) {
					manager = (userDb.getUser(aReq.getResolverId())).getUserFirst() + " " +
							(userDb.getUser(aReq.getResolverId())).getUserLast();
				}
				 
				result.add(new ReqDto(aReq.getrId(),aReq.getrAmount(),aReq.getrDescription(),
						rec,datef.format(aReq.getrSubmitted()),resolvedDate,
						(userDb.getUser(aReq.getAuthorId())).getUserName(),manager,myTables.getReqType(aReq.getrType()),
						myTables.getReqStatus(aReq.getrStatus())));
			}
			
			
		return result;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.ReqServiceContract#updateReqManager(int, int, int)
	 */
	@Override
	public boolean updateReqManager(int mangId, int statusId, int reqId) {
		boolean result = false;
		result = myReqDb.updateReqStatus(reqId, statusId, mangId);
		return result;
	}

	@Override
	public List<ReqDto> getAllResolvedReqs() {
		List<ReqDto> result = new ArrayList<>();
		String rec = "";
		String resolvedDate = "";
		String manager = "";
		DateFormat datef = new SimpleDateFormat("MM/dd/yyyy");

			for(ReimRequest aReq : myReqDb.getAllReqResolved()) {
				rec = "";
				resolvedDate = "";
				manager = "";
				
				if (aReq.getrReceipt() != null) {
					rec ="Receipt";
				}
				if (aReq.getrResolved() != null) {
					resolvedDate = datef.format(aReq.getrResolved());
				}
				if (aReq.getResolverId() > 0) {
					manager = (userDb.getUser(aReq.getResolverId())).getUserFirst() + " " +
							(userDb.getUser(aReq.getResolverId())).getUserLast();
				}
				 
				result.add(new ReqDto(aReq.getrId(),aReq.getrAmount(),aReq.getrDescription(),
						rec,datef.format(aReq.getrSubmitted()),resolvedDate,
						(userDb.getUser(aReq.getAuthorId())).getUserName(),manager,myTables.getReqType(aReq.getrType()),
						myTables.getReqStatus(aReq.getrStatus())));
			}
			
			
		return result;
	}

	@Override
	public List<ReqDto> getAllPendingReqsByUser(int userId) {
		List<ReqDto> result = new ArrayList<>();
		String rec = "";
		String resolvedDate = "";
		String manager = "";
		DateFormat datef = new SimpleDateFormat("MM/dd/yyyy");

			for(ReimRequest aReq : myReqDb.getAllReqPendingForUser(userId)) {
				rec = "";
				resolvedDate = "";
				manager = "";
				
				if (aReq.getrReceipt() != null) {
					rec ="Receipt";
				}
				if (aReq.getrResolved() != null) {
					resolvedDate = datef.format(aReq.getrResolved());
				}
				if (aReq.getResolverId() > 0) {
					manager = (userDb.getUser(aReq.getResolverId())).getUserFirst() + " " +
							(userDb.getUser(aReq.getResolverId())).getUserLast();
				}
				 
				result.add(new ReqDto(aReq.getrId(),aReq.getrAmount(),aReq.getrDescription(),
						rec,datef.format(aReq.getrSubmitted()),resolvedDate,
						(userDb.getUser(aReq.getAuthorId())).getUserName(),manager,myTables.getReqType(aReq.getrType()),
						myTables.getReqStatus(aReq.getrStatus())));
			}
			
			
		return result;
	}

	@Override
	public List<ReqDto> getAllResolvedReqsByUser(int userId) {
		List<ReqDto> result = new ArrayList<>();
		String rec = "";
		String resolvedDate = "";
		String manager = "";
		DateFormat datef = new SimpleDateFormat("MM/dd/yyyy");

			for(ReimRequest aReq : myReqDb.getAllReqResolvedForUser(userId)) {
				rec = "";
				resolvedDate = "";
				manager = "";
				
				if (aReq.getrReceipt() != null) {
					rec ="Receipt";
				}
				if (aReq.getrResolved() != null) {
					resolvedDate = datef.format(aReq.getrResolved());
				}
				if (aReq.getResolverId() > 0) {
					manager = (userDb.getUser(aReq.getResolverId())).getUserFirst() + " " +
							(userDb.getUser(aReq.getResolverId())).getUserLast();
				}
				 
				result.add(new ReqDto(aReq.getrId(),aReq.getrAmount(),aReq.getrDescription(),
						rec,datef.format(aReq.getrSubmitted()),resolvedDate,
						(userDb.getUser(aReq.getAuthorId())).getUserName(),manager,myTables.getReqType(aReq.getrType()),
						myTables.getReqStatus(aReq.getrStatus())));
			}
			
			
		return result;
	}

}
