package com.revature.expensers.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/reqview")
public class SRViewServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4221929105811145861L;
	
	public SRViewServlet() {
		
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("fragments/submitreq.html").forward(req, resp);
	}
}
