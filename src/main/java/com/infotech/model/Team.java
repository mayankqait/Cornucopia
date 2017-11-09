package com.infotech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Team")
@EntityListeners(AuditingEntityListener.class)
public class Team {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private int id;
	
	private String teamName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Team_Member", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "empId") })
	List<Member> memberList;
	private String noOfGames;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Team_Game", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "gameId") })
	List<Game> gameList;
	
	
	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", memberList=" + memberList + ", noOfGames=" + noOfGames
				+ ", gameList=" + gameList + "]";
	}

	public Team() {
		super();
	}

	public Team(Integer id, String teamName, List<Member> memberList, String noOfGames, List<Game> gameList) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.memberList = memberList;
		this.noOfGames = noOfGames;
		this.gameList = gameList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	public List<Game> getGameList() {
		return gameList;
	}
	public void setGameList(List<Game> gameList) {
		this.gameList = gameList;
	}
	
	
	public String getNoOfGames() {
		return noOfGames;
	}
	public void setNoOfGames(String noOfGames) {
		this.noOfGames = noOfGames;
	}
	
	
	
}
