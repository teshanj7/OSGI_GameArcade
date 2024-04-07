package com.gamearcade.developerpublisher;

public class GameModel {
	private String gameId,gameName,gameDeveloper,genre,difficulty,otherDetails;
	
	public GameModel() {
		super();
	}
	
	//constructor
	public GameModel(String gameId, String gameName, String gameDev, 
				String genre, String diff, String otherDet) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.gameDeveloper = gameDev;
		this.genre = genre;
		this.difficulty = diff;
		this.otherDetails = otherDet;
		
	}
	
	//getters and setters implementation
	public String getGameId() {
		return gameId;
	}
	
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
	public String getGameName() {
		return gameName;
	}
	
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public String getGameDev() {
		return gameDeveloper;
	}
	
	public void setGameDev(String gameDeveloper) {
		this.gameDeveloper = gameDeveloper;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(String diff) {
		this.difficulty = diff;
	}
	
	public String getOtherDetails() {
		return otherDetails;
	}
	
	public void setOtherDetails(String otherDet) {
		this.otherDetails = otherDet;
	}
	
	@Override
	public String toString() {
		return "Game Id: " + gameId + "\nGame Name: " + gameName + "\nDeveloper: " + gameDeveloper
			    + "\nGenre: " + genre + "\nDifficulty: " + difficulty + "\nOther Details: " + otherDetails;
	}
}
