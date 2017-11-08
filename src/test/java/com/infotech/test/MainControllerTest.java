package com.infotech.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.infotech.controller.MainController;
import com.infotech.main.CornucopiaApplication;
import com.infotech.model.Game;
import com.infotech.model.Member;
import com.infotech.model.Team;
import com.infotech.service.TeamService;



@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(MainController.class)
@WebAppConfiguration
@ContextConfiguration(classes = CornucopiaApplication.class )
public class MainControllerTest {
     
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TeamService teamService;
	
	@Test
	public void getAllTeam() throws Exception{
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
	    List<Team> list = Arrays.asList(t);
	    
	    
	    
		when(teamService.findByName("Dhoom")).thenReturn(list);
		mvc.perform(get("/cornucopia/12")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		        .andExpect(status().isOk());
	}
}
