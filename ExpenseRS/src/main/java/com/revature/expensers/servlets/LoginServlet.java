package com.revature.expensers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ers.dto.UserDto;
import com.revature.ers.service.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2708193652871835850L;
	
	
	public LoginServlet() {
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post works....");
		UserDto current = new UserDto();
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		UserService servUser = new UserService();
		
		current = servUser.validateUser(userName, userPass);

		if(current.getUserId() > 0){
			HttpSession session = req.getSession(); 
			
			session.setAttribute("user", current);
			req.getRequestDispatcher("mainapp.html").forward(req, resp);
		}else{
			System.err.println("invalid information. sending client back to login.html");

			resp.sendRedirect("index.html");
		}
		
	}

}
