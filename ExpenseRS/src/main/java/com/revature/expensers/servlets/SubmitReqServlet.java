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
import com.revature.ers.dto.ReqDto;
import com.revature.ers.dto.UserDto;
import com.revature.ers.model.ReimRequest;
import com.revature.ers.service.ReqService;
import com.revature.ers.service.TableService;


@WebServlet("/submitreq")
public class SubmitReqServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2845149684140969218L;
	
	
	public SubmitReqServlet() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 TableService myTableS = new TableService();
		 ReqService myReqService = new ReqService();
		 BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
	        String json = "";
	        if(br != null){
	            json = br.readLine();
	        }
		
		ObjectMapper toMyObject = new ObjectMapper();
			
		ReqDto reqS = toMyObject.readValue(json, ReqDto.class);
		
		HttpSession session = req.getSession();
		UserDto current = (UserDto) session.getAttribute("user");
		
		
		ReimRequest inserDb = new ReimRequest(reqS.getrAmount(),reqS.getrDescription(),
				current.getUserId(),myTableS.getReqTypeId(reqS.getrType()));
		myReqService.submitReq(inserDb);
		
	}

}
