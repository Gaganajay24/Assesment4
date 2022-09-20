package com.perfios.display;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perfios.dto.Players;
import com.perfios.team.TeamFormation;


@WebServlet("/Display_final_team")
public class Display_final_team extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TeamFormation tf=new TeamFormation();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		List<Players> final_team=tf.team_formation();
		
		 out.print("<table border='1' width='100%'");  
		 out.println("<tr><th>Id</th><th>Name</th><th>Total_matches_Played</th><th>Total_runs_scored</th><th>Total_Wickets_Taken</th><th>Number_of_out_on_zero</th><th>Player_type</th></tr>");
		 
		 for(Players p:final_team) {
			 
			 out.println("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td><td>"+p.getTotal_matches()+"</td><td>"+p.getTotal_runs()+"</td><td>"+p.getWickets_taken()+"</td><td>"+p.getOut_on_zero()+"</td><td>"+p.getPlayer_type()+"</td></tr>");   
		 }
	
	}

}
