/**
 * 
 */
package com.revature.ers.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.ers.dao.UserDao;
import com.revature.ers.dto.UserDto;
import com.revature.ers.model.User;

/**
 * @author Mohamed
 *
 */
public class UserService implements UserServiceContract {
	
	
	private UserDao userDb = new UserDao();
	
	
	public UserService() {
		
	}

	
	/* (non-Javadoc)
	 * @see com.revature.ers.service.UserServiceContract#validateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public UserDto validateUser(String userName, String userPass) {
		UserDto result = new UserDto();
		User flag = userDb.userExist(userName);
		if (flag.getUserId() > 0 && flag.getUserPass().equals(userPass)) {
			result = new UserDto(flag);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.UserServiceContract#checkUserExist(java.lang.String)
	 */
	@Override
	public boolean checkUserExist(String userName) {
		boolean result = false;
		User flag = userDb.userExist(userName);
		if ( flag.getUserId() > 0 ) {
			result = true;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.UserServiceContract#registerUser(com.revature.ers.model.User)
	 */
	@Override
	public boolean registerUser(User aUser) {
		boolean result = userDb.insertUser(aUser);

		return result;
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.UserServiceContract#updateUser(com.revature.ers.model.User)
	 */
	@Override
	public boolean updateUser(User aUser) {
		if(aUser.getUserPass().isEmpty()) {
			return userDb.updateUserNoPass(aUser);
		} else {
			return userDb.updateUser(aUser);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.revature.ers.service.UserServiceContract#getAllEmp()
	 */
	@Override
	public List<UserDto> getAllEmp() {
		List<UserDto> result = new ArrayList<>();
		for(User auser: userDb.getUserList()) {
			result.add(new UserDto(auser));
		}
		return result;
	}


	@Override
	public User getUser(int userId) {
		User result = userDb.getUser(userId);
		
		return result;
	}

}
