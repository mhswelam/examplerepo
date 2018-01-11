/**
 * 
 */
package com.revature.ers.dao;

import java.io.File;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ers.model.ReimRequest;
import com.revature.ers.model.User;

/**
 * @author Mohamed
 *
 */
public class RequestDao implements RequestDaoContract {
	
	private static String url = "jdbc:oracle:thin:@usfdbjava.cvkdivlrr1b2.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String userName = "ERS";
	private static String password = "p4ss";
	final  int pending = 22;
	final int approved = 55;
	final int denied = 66;
	
	
	
	
	@Override
	public boolean insertRequest(ReimRequest arequest) {
		boolean result = false;
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "{call INSERT_REIMBURSEMENT(?,?,?,?)}"; 
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, arequest.getrAmount());
			cs.setString(2, arequest.getrDescription());
			cs.setInt(3, arequest.getAuthorId());
			cs.setInt(4, arequest.getrType());
			
			int state = cs.executeUpdate();
			if (state == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}





	@Override
	public boolean updateRequestReceipt(int reqId, File afile) {
		boolean result = false;
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "{call UPDATE_REIMBURSEMENT_RECEIPT(?,?)}"; 
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reqId);
			cs.setBlob(2, (Blob)afile);
			
			int state = cs.executeUpdate();
			if (state == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}





	@Override
	public boolean updateReqStatus(int reqId, int aStatus, int resId) {
		boolean result = false;
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "{call UPDATE_REIMBURSEMENT_STATUS(?,?,?)}"; 
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reqId);
			cs.setInt(2, aStatus);
			cs.setInt(3, resId);
			
			int state = cs.executeUpdate();
			if (state == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}





	@Override
	public List<ReimRequest> getAllReqByUser(int userId) {
		List<ReimRequest> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.add(new ReimRequest(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getBlob(4),
						rs.getDate(5),rs.getDate(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}





	@Override
	public List<ReimRequest> getAllReqPending() {
		List<ReimRequest> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pending);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.add(new ReimRequest(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getBlob(4),
						rs.getDate(5),rs.getDate(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}





	@Override
	public List<ReimRequest> getAllReqResolved() {
		List<ReimRequest> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS = ? AND RT_STATUS = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, approved);
			ps.setInt(2, denied);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.add(new ReimRequest(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getBlob(4),
						rs.getDate(5),rs.getDate(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}





	@Override
	public List<ReimRequest> getAllReqResolvedForUser(int userId) {
		List<ReimRequest> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS = ? AND RT_STATUS = ? AND U_ID_AUTHOR = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, approved);
			ps.setInt(2, denied);
			ps.setInt(3, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.add(new ReimRequest(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getBlob(4),
						rs.getDate(5),rs.getDate(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}





	@Override
	public List<ReimRequest> getAllReqPendingForUser(int userId) {
		List<ReimRequest> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS = ? AND U_ID_AUTHOR = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pending);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.add(new ReimRequest(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getBlob(4),
						rs.getDate(5),rs.getDate(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	

	

}
