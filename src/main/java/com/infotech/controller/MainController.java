package com.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.model.Team;
import com.infotech.repository.TeamRepository;
import com.infotech.service.TeamServiceImpl;

@RestController
@RequestMapping(value="/cornucopia")
public class MainController {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TeamServiceImpl teamServiceImpl;
	
	@PostMapping(path="/add")
	public ResponseEntity addTeam(@RequestBody Team t) {
		 teamServiceImpl.save(t);
		return new ResponseEntity(t, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public Team getTeamInfo(@PathVariable("id") Integer id) {
		return teamServiceImpl.findOne(id);
	}
	
	@GetMapping(path="/findByName/{teamName}")
	public List<Team> getByName(@PathVariable("teamName") String teamName) {
		return teamServiceImpl.findByName(teamName);
	}
    
	@GetMapping(path="/")
	public List<Team> getAllEmployee() {
		return (List<Team>)teamServiceImpl.findAll();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id) {
		return teamServiceImpl.delete(id);
	}
	
	@DeleteMapping("/deleteByTeamName/{teamName}")
	public String delete(@PathVariable("teamName") String teamName) {
		return teamServiceImpl.deleteByName(teamName);
	}
}
