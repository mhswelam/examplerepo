package com.revature.expensers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.revature.ers.dto.ReceviedString;
import com.revature.ers.dto.ReqDto;
import com.revature.ers.dto.UserDto;
import com.revature.ers.service.ReqService;

@WebServlet("/getallreqs")
public class LoadAllReimServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5347780357866847648L;
	final String pending = "Pending";
	final String resolved = "Resolved";
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReqService reqService = new ReqService();
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        ObjectMapper toMyObject = new ObjectMapper();
		
		ReceviedString userSelected = toMyObject.readValue(json, ReceviedString.class);
		List<ReqDto> reqList = new ArrayList<>();
		HttpSession session = req.getSession();
		UserDto current = (UserDto) session.getAttribute("user");
        if ((userSelected.getId1()).equals(pending)) {
        	reqList = reqService.getAllPendingReqsByUser(current.getUserId());
        } else if ((userSelected.getId1()).equals(resolved)) {
        	reqList = reqService.getAllResolvedReqsByUser(current.getUserId());
        }
        ObjectMapper mapper = new ObjectMapper();
		String sendOutJson = mapper.writeValueAsString(reqList);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(sendOutJson);
	}
	
	

}
