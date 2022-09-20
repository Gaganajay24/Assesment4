package com.perfios.validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perfios.dao.CricketDao;


@WebServlet("/Update_player_name_validation")
public class Update_player_name_validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		
		HttpSession session=request.getSession();
		session.setAttribute("name", name);
		CricketDao cd=new CricketDao();
		if(cd.check_name(name)) {
			
			//response.sendRedirect("Update_player_details name?="+name);
			RequestDispatcher rd=request.getRequestDispatcher("updatePlayerDetails.html");
			rd.forward(request, response);
			
			
		}
		else {
			out.println("name doesn't exist");
		}
	}

}
