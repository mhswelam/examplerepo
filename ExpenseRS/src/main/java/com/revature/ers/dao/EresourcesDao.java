/**
 * 
 */
package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.revature.ers.model.ReqStatus;
import com.revature.ers.model.Reqtype;
import com.revature.ers.model.User;
import com.revature.ers.model.UserRole;

/**
 * @author Mohamed
 *
 */
public class EresourcesDao implements EresourcesDaoContract {
	
	
	private static String url = "jdbc:oracle:thin:@usfdbjava.cvkdivlrr1b2.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String userName = "ERS";
	private static String password = "p4ss";

	/* (non-Javadoc)
	 * @see com.revature.ers.dao.EresourcesDaoContract#getUserRoles()
	 */
	@Override
	public Map<Integer, UserRole> getUserRoles() {
		Map<Integer, UserRole> result = new HashMap<>();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_USER_ROLES";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.put(rs.getInt(1), new UserRole(rs.getInt(1),rs.getString(2)));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.dao.EresourcesDaoContract#getrStatus()
	 */
	@Override
	public Map<Integer, ReqStatus> getrStatus() {
		Map<Integer, ReqStatus> result = new HashMap<>();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.put(rs.getInt(1), new ReqStatus(rs.getInt(1),rs.getString(2)));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.dao.EresourcesDaoContract#getrType()
	 */
	@Override
	public Map<Integer, Reqtype> getrType() {
		Map<Integer, Reqtype> result = new HashMap<>();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.put(rs.getInt(1), new Reqtype(rs.getInt(1),rs.getString(2)));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
