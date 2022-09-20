package com.perfios.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perfios.dao.CricketDao;


@WebServlet("/Team_condition")
public class Team_condition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		CricketDao cd=new CricketDao();
		ResultSet rs=cd.get_all_players();
		int i=0;
		try {
			while(rs.next()) {
				i++;	
			}
			if(i<20) {
				
				System.out.println(i);
				RequestDispatcher rd=request.getRequestDispatcher("addPlayer.html");
				rd.forward(request, response);
				out.println("Not enough players");
			}
			else {
				
				if(cd.get_bowlers()<3) {
					
					System.out.println(cd.get_bowlers());
					RequestDispatcher rd=request.getRequestDispatcher("addPlayer.html");
					rd.forward(request, response);
					out.println("Not enough players");
				}
				else {
					
					if(cd.get_wicket_keepers()<1) {
						System.out.println(cd.get_wicket_keepers());
						RequestDispatcher rd=request.getRequestDispatcher("addPlayer.html");
						rd.forward(request, response);
						out.println("Not enough wicket Keepers ");
					}
					else {
						System.out.println("team done");
						RequestDispatcher rd=request.getRequestDispatcher("Display_final_team");
						rd.forward(request, response);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
