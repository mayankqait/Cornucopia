package com.infotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotech.model.Game;
import com.infotech.model.Member;
import com.infotech.model.Team;
import com.infotech.repository.TeamRepository;

@Component
public class TeamServiceImpl implements TeamService {
    
	@Autowired 
	private TeamRepository teamRepository;
	
	@Override
	public List<Team> findAll() {
		return teamRepository.findAll();
	}


	/*@Override
	public List<Team> findByName(String name) {
		return null;
	}
*/
	@Override
	public Team save(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public Team findOne(Integer id) {
		return teamRepository.findOne(id);
	}

	@Override
	public String delete(Integer id) {
		teamRepository.delete(id);
		return "Team with name "+id+" is deleted";
		
	}
	
	@Override
	public List<Team> findByName(String teamName) {
		 return (List<Team>) teamRepository.findByName(teamName);	
	}


	@Override
	public String deleteByName(String teamName) {
		/*int c=teamRepository.deleteByTeamName(teamName);
		if(c==1) {
			return "Team with name "+teamName+" is deleted";
		}
		else {
			return "No team exist with "+teamName+" name.";
		}*/
		String  c= delete(teamRepository.findByName(teamName).get(0).getId());
		return c;
	}
	
	@Override
	public List<Team> getByNoOfGames(String noOfGames){
		return  (List<Team>)teamRepository.findByNoOfGames(noOfGames);
	}
	
	public List<Member> getMemberByTeam(String team){
		List<Team> tList=findByName(team);
		return (List<Member>)tList.get(0).getMemberList();
	}
    
	public List<Game> getGamesByTeam(String team){
		List<Team> tList=findByName(team);
		return (List<Game>)tList.get(0).getGameList();
	}
}
