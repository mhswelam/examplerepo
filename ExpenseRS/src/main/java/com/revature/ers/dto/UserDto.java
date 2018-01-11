/**
 * 
 */
package com.revature.ers.dto;

import com.revature.ers.model.User;

/**
 * @author Mohamed
 *
 */
public class UserDto extends User {

	/**
	 * 
	 */
	public UserDto() {
		super();
	}

	/**
	 * @param userName
	 * @param userPass
	 * @param userFirst
	 * @param userLast
	 * @param userEmail
	 * @param userRole
	 */
	public UserDto(String userName, String userFirst, String userLast, String userEmail,
			int userRole) {
		super(userName, null, userFirst, userLast, userEmail, userRole);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userId
	 * @param userName
	 * @param userPass
	 * @param userFirst
	 * @param userLast
	 * @param userEmail
	 * @param userRole
	 */
	public UserDto(User aUser) {
		super(aUser.getUserId(), aUser.getUserName(), null, aUser.getUserFirst(),
				aUser.getUserLast(), aUser.getUserEmail(), aUser.getUserRole());
		
	}

}
