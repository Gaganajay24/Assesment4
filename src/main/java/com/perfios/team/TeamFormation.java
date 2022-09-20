package com.perfios.team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.perfios.dao.CricketDao;
import com.perfios.dto.Players;


class ScoreComparator implements Comparator<Players>{
    public int compare(Players o1,Players o2){
        return ((o1.getTotal_runs()/o1.getTotal_matches())-(o2.getTotal_runs()/o2.getTotal_matches()));
    }
}

class NameComparator implements Comparator<Players>{
    public int compare(Players o1,Players o2){
        return o1.getName().compareTo(o2.getName());
    }
}


public class TeamFormation {
	
	
	static CricketDao cd=new CricketDao();
	List<Players> players=new ArrayList<Players>();
	
	public List all_players() {
		
		ResultSet rs=cd.get_all_players();
		try {
			while(rs.next()) {
				Players cp=new Players();
				
				cp.setId(rs.getInt(1));
				cp.setName(rs.getString(2));
				cp.setTotal_matches(Integer.parseInt(rs.getString(3)));
				cp.setTotal_runs(Integer.parseInt(rs.getString(4)));
				cp.setWickets_taken(Integer.parseInt(rs.getString(5)));
				cp.setOut_on_zero(Integer.parseInt(rs.getString(6)));
				cp.setPlayer_type(rs.getString(7));
				players.add(cp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return players;
		
	}
	
	public List team_formation() {
		List<Players> final_team =new ArrayList<Players>();
		
		
		int i=0;
		
				players=all_players();
				Collections.sort(players,new ScoreComparator());
		        Collections.reverse(players);
		        boolean wicket=false;

		            for(Players p:players){
		                if(p.getPlayer_type().equalsIgnoreCase("Bowler")){
		                    i++;
		                    final_team.add(p);
		                    if(i>4)
		                        break;

		                }
		            }

		            if(i<11) {
		                for (Players p : players) {
		                    if (p.getPlayer_type().equalsIgnoreCase("Batsman") || (p.getPlayer_type().equalsIgnoreCase("WicketKeeper"))) {
		                        if (p.getPlayer_type().equalsIgnoreCase("WicketKeeper")) {
		                            if (wicket == false) {
		                                wicket = true;
		                                final_team.add(p);
		                                i++;
		                            }
		                        } else {
		                            final_team.add(p);
		                            i++;
		                        }
		                        if (i == 11)
		                            break;
		                    }
		                }
		            }
				
			
			
			
	
		return final_team;
	}

}
