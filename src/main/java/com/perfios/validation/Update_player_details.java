package com.perfios.validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perfios.dao.CricketDao;
import com.perfios.dto.Players;


@WebServlet("/Update_player_details")
public class Update_player_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Players cp=new Players();
	static CricketDao cd=new CricketDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//cp.setName(request.getParameter("name"));
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");
		cp.setName(name);
		cp.setOut_on_zero(Integer.parseInt(request.getParameter("out_on_zero")));
		cp.setPlayer_type(request.getParameter("player_type"));
		cp.setTotal_matches(Integer.parseInt(request.getParameter("matches_played")));
		cp.setTotal_runs(Integer.parseInt(request.getParameter("total_runs")));
		cp.setWickets_taken(Integer.parseInt(request.getParameter("wickets_taken")));
		
		if(cd.update_player(cp)) {
			out.println("Details Updated Successfully");
		}
		else {
			out.println("Details updation failed");
		}
		
	
	}

}
