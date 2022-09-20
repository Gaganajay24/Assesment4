package com.perfios.validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perfios.dao.CricketDao;
import com.perfios.dto.Players;


@WebServlet("/AddPlayer")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		Players cp=new Players();
		CricketDao cd=new CricketDao();
		
		cp.setId(Integer.parseInt(request.getParameter("id")));
		cp.setName(request.getParameter("name"));
		cp.setOut_on_zero(Integer.parseInt(request.getParameter("out_on_zero")));
		cp.setPlayer_type(request.getParameter("player_type"));
		cp.setTotal_matches(Integer.parseInt(request.getParameter("matches_played")));
		cp.setTotal_runs(Integer.parseInt(request.getParameter("total_runs")));
		cp.setWickets_taken(Integer.parseInt(request.getParameter("wickets_taken")));
		
		if(cd.add_player(cp)) {
			out.println("Player addition successful");
		}
		else{
			out.println("Player addition failed");
		}
	}

}
