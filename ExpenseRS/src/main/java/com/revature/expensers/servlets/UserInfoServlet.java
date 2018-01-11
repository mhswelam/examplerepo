package com.revature.expensers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dto.UserDto;



@WebServlet("/userinfo")
public class UserInfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8249361303356986917L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		UserDto current = (UserDto) session.getAttribute("user");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(current);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}

}
