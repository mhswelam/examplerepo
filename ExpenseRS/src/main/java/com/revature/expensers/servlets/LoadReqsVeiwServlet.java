package com.revature.expensers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reqsview")
public class LoadReqsVeiwServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3198329735332758118L;
	
	
	public LoadReqsVeiwServlet() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("fragments/viewreq.html").forward(req, resp);
	}
	
	

}
