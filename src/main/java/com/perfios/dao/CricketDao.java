package com.perfios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.perfios.dto.Players;

public class CricketDao {
	
	public Statement getStatement() {
		Statement st=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Cricket","root","password");
			st=con.createStatement();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return st;
		
	}
	
	public boolean add_player(Players cd) {
		
		boolean status=false;
		try {
			
			String sql="insert into CricketDetails values("+cd.getId()+",'"+cd.getName()+"',"+cd.getTotal_matches()+","+cd.getTotal_runs()+","+cd.getWickets_taken()+","+cd.getOut_on_zero()+",'"+cd.getPlayer_type()+"')";      
			if(getStatement().executeUpdate(sql)>=1) {
				status=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean check_name(String cname) {
		
		boolean status=false;
		try {
			
			String sql="select name from CricketDetails where name='"+cname+"'";
			ResultSet rs=getStatement().executeQuery(sql);
			if(rs.next()) {
				status=true;
			}
		}
		catch(Exception e) {
			
		}
		return status;
	}
	
	public boolean update_player(Players cp) {
		
		boolean status=false;
		
		try {
			
			String sql="update CricketDetails set matches_played="+cp.getTotal_matches()+",total_runs="+cp.getTotal_runs()+",wickets_taken="+cp.getWickets_taken()+",out_on_zezro_score="+cp.getOut_on_zero()+",player_type='"+cp.getPlayer_type()+"' where name='"+cp.getName()+"'"; 
			//String sql="update CricketDetails set out_on_zezro_score="+cp.getOut_on_zero()+" where name='"+cp.getName()+"'";
			int n = getStatement().executeUpdate(sql) ;
			System.out.println(cp.getName());
			if(n>=1) {
				status=true;
			}
			System.out.println(status);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public ResultSet get_all_players() {
		
		ResultSet rs=null;
		try {
			
			String sql="select * from CricketDetails";
			 rs=getStatement().executeQuery(sql);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int get_bowlers() {
		
		int i=0;
		try {
			
			String sql="select player_type from CricketDetails";
			ResultSet rs=getStatement().executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getString(1).equalsIgnoreCase("bowler"));
				i++;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
public int get_wicket_keepers() {
		
		int i=0;
		try {
			
			String sql="select player_type from CricketDetails";
			ResultSet rs=getStatement().executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getString(1).equalsIgnoreCase("wicketKeeper"));
				i++;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
