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
import com.revature.ers.model.ReqStatus;
import com.revature.ers.service.TableService;


@WebServlet("/reqallstatus")
public class LAllStatusServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2191566945977032431L;
	
	
	
	
	public LAllStatusServlet() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TableService myTables = new TableService();
		List<ReqStatus> txlist = myTables.getReqStatusList();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(txlist);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}

}
