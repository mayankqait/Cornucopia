package com.infotech.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Game")
@EntityListeners(AuditingEntityListener.class)
public class Game {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gameId")
    private int gameId;
	private String name;
	private String Description;
	private String accessories;
	
	
	public Game() {
		super();
	}
	public Game(int gameId, String name, String description, String accessories) {
		super();
		this.gameId = gameId;
		this.name = name;
		Description = description;
		this.accessories = accessories;
	}
	
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAccessories() {
		return accessories;
	}
	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}
	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", name=" + name + ", Description=" + Description + ", accessories="
				+ accessories + "]";
	}

	
	
	
}
