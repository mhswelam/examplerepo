package com.revature.expensers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateview")
public class UpdateViewServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6995325520223708681L;
	
	public UpdateViewServlet() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("fragments/updateinfo.html").forward(req, resp);
	}
	

}
