package com.infotech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infotech.model.Team;
@Service
public interface TeamService {
   
	public Team save(Team team);
	public Team findOne(Integer id);
	public String delete(Integer  id);
	public String deleteByName(String teamName);
	public List<Team> findByName(String teanName);
	//public List<Team> findBy(String )
    public	List<Team> findAll();
}
