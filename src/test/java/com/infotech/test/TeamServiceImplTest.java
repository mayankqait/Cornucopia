package com.infotech.test;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.infotech.model.*;
import com.infotech.repository.TeamRepository;
import com.infotech.service.TeamService;
import com.infotech.service.TeamServiceImpl;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class TeamServiceImplTest {
    
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public TeamService employeeService() {
            return new TeamServiceImpl();
        }
    }
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private TeamServiceImpl teamServiceImpl;
	
	@MockBean
	private TeamRepository teamReposotory;
	
	@Before
	public void setUp() {
		List<Game> games=new ArrayList<Game>();
		Game g=new Game();
		g.setGameId(1);
		g.setAccessories("Chair and tables");
		g.setName("Lucky 7");
		g.setDescription("Interesting");
		games.add(g);
		
		List<Member> members=new ArrayList<Member>();
		Member m=new Member();
		m.setEmpId(23);
		m.setName("Vipul");
		m.setEmail("a@gmail.com");
		m.setSkypeId("b@outlook.com");
		m.setMobile(98765);
		members.add(m);
		
	    Team t=new Team();
	    t.setId(12);
	    t.setGameList(games);
	    t.setMemberList(members);
	    t.setNoOfGames("1");
	    t.setTeamName("Dhoom");
	 
	   /* Mockito.when(TeamRepository.findOne(t.getId()))
	      .thenReturn((List<Team>) t);*/
	}
	
	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
	    String name = "Dhoom";
	    Team found = teamServiceImpl.findOne(12);
	  
	     Assert.assertEquals(found.getTeamName(), name);
	 }
}
