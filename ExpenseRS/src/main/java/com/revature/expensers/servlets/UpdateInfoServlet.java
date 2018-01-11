package com.revature.expensers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dto.UserDto;
import com.revature.ers.service.UserService;

@WebServlet("/updateinfo")
public class UpdateInfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4247659752897313787L;
	
	public UpdateInfoServlet() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 UserService myUserS = new UserService();
		 BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
	        String json = "";
	        if(br != null){
	            json = br.readLine();
	        }
		
		ObjectMapper toMyObject = new ObjectMapper();
			
		UserDto updatedU = toMyObject.readValue(json, UserDto.class);
		
		HttpSession session = req.getSession();
		UserDto current = (UserDto) session.getAttribute("user");
		updatedU.setUserId(current.getUserId());
		updatedU.setUserName(current.getUserName());
		updatedU.setUserRole(current.getUserRole());
		// send updated info to DB
		boolean done = myUserS.updateUser(updatedU);
		if (done) {
			req.getRequestDispatcher("fragments/updatesuccsees.html").forward(req, resp);
		} else {
			req.getRequestDispatcher("fragments/updatefail.html").forward(req, resp);
		}
		
		
	}

}
