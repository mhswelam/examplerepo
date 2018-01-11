package com.revature.expensers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.Reqtype;
import com.revature.ers.service.TableService;

@WebServlet("/reqtypes")
public class PtypeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8070647777191644935L;
	
	public PtypeServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TableService myTables = new TableService();
		List<Reqtype> txlist = myTables.getReqTypeList();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(txlist);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}

}
