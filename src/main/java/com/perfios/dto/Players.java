package com.perfios.dto;

public class Players {

	
	private int id;
	private String name;
	private int total_runs;
	private int total_matches;
	private int wickets_taken;
	private int out_on_zero;
	private String player_type;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal_runs() {
		return total_runs;
	}
	public void setTotal_runs(int total_runs) {
		this.total_runs = total_runs;
	}
	public int getTotal_matches() {
		return total_matches;
	}
	public void setTotal_matches(int total_matches) {
		this.total_matches = total_matches;
	}
	public int getWickets_taken() {
		return wickets_taken;
	}
	public void setWickets_taken(int wickets_taken) {
		this.wickets_taken = wickets_taken;
	}
	public int getOut_on_zero() {
		return out_on_zero;
	}
	public void setOut_on_zero(int out_on_zero) {
		this.out_on_zero = out_on_zero;
	}
	public String getPlayer_type() {
		return player_type;
	}
	public void setPlayer_type(String player_type) {
		this.player_type = player_type;
	}
	
}
