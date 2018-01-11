/**
 * 
 */
package com.revature.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ers.model.User;

/**
 * @author Mohamed
 *
 */
public class UserDao implements UserDaoContract {
	
	
	
	private static String url = "jdbc:oracle:thin:@usfdbjava.cvkdivlrr1b2.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String userName = "ERS";
	private static String password = "p4ss";

	/**
	 * 
	 */
	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.dao.UserDaoContract#insertUser(com.revature.ers.model.User)
	 */
	@Override
	public boolean insertUser(User aUser) {
		boolean result = false;
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "{call INSERT_USER(?,?,?,?,?,?)}"; 
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, aUser.getUserName());
			cs.setString(2, aUser.getUserPass());
			cs.setString(3, aUser.getUserFirst());
			cs.setString(4, aUser.getUserLast());
			cs.setString(5, aUser.getUserEmail());
			cs.setInt(6, aUser.getUserRole());
			
			int state = cs.executeUpdate();
			if (state == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
	
	/* (non-Javadoc)
	 * @see com.revature.ers.dao.UserDaoContract#updateUser(com.revature.ers.model.User)
	 */
	@Override
	public boolean updateUser(User aUser) {
		boolean result = false;
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "{call UPDATE_USER(?,?,?,?,?)}"; 
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, aUser.getUserId());
			cs.setString(2, aUser.getUserPass());
			cs.setString(3, aUser.getUserFirst());
			cs.setString(4, aUser.getUserLast());
			cs.setString(5, aUser.getUserEmail());
			
			int state = cs.executeUpdate();
			if (state == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	


	/* (non-Javadoc)
	 * @see com.revature.ers.dao.UserDaoContract#getUserList()
	 */
	@Override
	public List<User> getUserList() {
		List<User> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_USERS";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7)));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User userExist(String aUserName) {
		User result = new User();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_USERS WHERE U_USERNAME = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aUserName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.setUserId(rs.getInt(1));
				result.setUserName(rs.getString(2));
				result.setUserPass(rs.getString(3));
				result.setUserFirst(rs.getString(4));
				result.setUserLast(rs.getString(5));
				result.setUserEmail(rs.getString(6));
				result.setUserRole(rs.getInt(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public User getUser(int userId) {
		User result = new User();
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "SELECT * FROM ERS_USERS WHERE U_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.setUserId(rs.getInt(1));
				result.setUserName(rs.getString(2));
				result.setUserPass(rs.getString(3));
				result.setUserFirst(rs.getString(4));
				result.setUserLast(rs.getString(5));
				result.setUserEmail(rs.getString(6));
				result.setUserRole(rs.getInt(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean updateUserNoPass(User aUser) {
		boolean result = false;
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			
			String sql = "{call UPDATE_USER_NOPASS(?,?,?,?)}"; 
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, aUser.getUserId());
			cs.setString(2, aUser.getUserFirst());
			cs.setString(3, aUser.getUserLast());
			cs.setString(4, aUser.getUserEmail());
			
			int state = cs.executeUpdate();
			if (state == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


}
