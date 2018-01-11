package com.revature.ers.dao;

import java.util.List;

import com.revature.ers.model.User;

/**
 * @author Mohamed
 *
 */
public interface UserDaoContract {
	
	
	
	/**
	 * Insert an new user and return true
	 * @param aUser
	 * @return
	 */
	public boolean insertUser(User aUser);
	
	
	/**
	 * Update a user 
	 * @param aUser
	 * @return true if got updated , false otherwise
	 */
	public boolean updateUser(User aUser);
	
	/**
	 * Update a user with out updating password
	 * @param aUser
	 * @return true if got updated , false otherwise
	 */
	public boolean updateUserNoPass(User aUser);
	/**
	 * Check if user name been used 
	 * 
	 * @param userName
	 * @return User if user exist or null otherwise
	 */
	public User userExist(String userName);
	
	
	
	
	
	/**
	 * Get a user list
	 * @return
	 */
	public List<User> getUserList();
	
	
	/**
	 * Get user by id
	 * @param userId
	 * @return User 
	 */
	public User getUser(int userId);
	
	

}
