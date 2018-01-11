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

@WebServlet("/getupdateinfo")
public class GetUpdateInfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2029027500797188331L;
	
	public GetUpdateInfoServlet() {
		// TODO Auto-generated constructor stub
	}
	
	
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
