/**
 * 
 */
package com.revature.ers.service;

import java.util.List;

import com.revature.ers.dto.UserDto;
import com.revature.ers.model.User;

/**
 * @author Mohamed
 *
 */
public interface UserServiceContract {
	
	
	/**
	 * To validate user 
	 * @param userName
	 * @param userPass
	 * @return UserDto to send to FEnd or Null otherwise
	 */
	public UserDto validateUser(String userName, String userPass);
	
	
	/**
	 * Checked if user name been use in the system
	 * @param userName
	 * @return true if user name been taken/ false otherwise
	 */
	public boolean checkUserExist(String userName);
	
	
	public boolean registerUser(User aUser);
	
	
	public boolean updateUser(User aUser);
	
	public User getUser(int userId);
	
	
	public List<UserDto> getAllEmp();

}
