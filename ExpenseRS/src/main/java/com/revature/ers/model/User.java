/**
 * 
 */
package com.revature.ers.model;

/**
 * @author Mohamed
 *
 */
public class User {

	/**
	 * 
	 */
	
	private int userId;
	private String userName;
	private String userPass;
	private String userFirst;
	private String userLast;
	private String userEmail;
	private int userRole;
	
	public User() {
		this.userId = 0;
		this.userPass = "";
	}

	/**
	 * @param userName
	 * @param userFirst
	 * @param userLast
	 * @param userEmail
	 * @param userRole
	 */
	public User(String userName, String userPass, String userFirst, String userLast, String userEmail, int userRole) {
		super();
		this.userId = 0;
		this.userName = userName;
		this.userPass = userPass;
		this.userFirst = userFirst;
		this.userLast = userLast;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}

	/**
	 * @param userId
	 * @param userName
	 * @param userFirst
	 * @param userLast
	 * @param userEmail
	 * @param userRole
	 */
	public User(int userId, String userName, String userPass, String userFirst, String userLast, String userEmail, int userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userFirst = userFirst;
		this.userLast = userLast;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userFirst
	 */
	public String getUserFirst() {
		return userFirst;
	}

	/**
	 * @param userFirst the userFirst to set
	 */
	public void setUserFirst(String userFirst) {
		this.userFirst = userFirst;
	}

	/**
	 * @return the userLast
	 */
	public String getUserLast() {
		return userLast;
	}

	/**
	 * @param userLast the userLast to set
	 */
	public void setUserLast(String userLast) {
		this.userLast = userLast;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userRole
	 */
	public int getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the userPass
	 */
	public String getUserPass() {
		return userPass;
	}

	/**
	 * @param userPass the userPass to set
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", userFirst="
				+ userFirst + ", userLast=" + userLast + ", userEmail=" + userEmail + ", userRole=" + userRole + "]";
	}
	
	
	

}
