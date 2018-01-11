package com.revature.expensers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ers.dto.UserDto;

@WebServlet("/checkrole")
public class MgbarServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4070719073879391249L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserDto current = (UserDto) session.getAttribute("user");
		if(current.getUserRole() == 99) {
			req.getRequestDispatcher("fragments/mgbar.html").forward(req, resp);
		} else {
			resp.setStatus(418);
		}
	}

}
