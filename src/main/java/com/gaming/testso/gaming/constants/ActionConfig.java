package com.gaming.testso.gaming.constants;

public enum ActionConfig {

	MOVE("Move", "S", GameStateEnum.MOVE), 
	FIGHT("Fight", "F", GameStateEnum.FIGHT),
	STOP("Stop", "R", GameStateEnum.STOP),
	START("Start", "E", GameStateEnum.START),
	SAVE("Save", "W", GameStateEnum.SAVE),
	QUIT("Quit", "Q", GameStateEnum.QUIT),
	CREATEPLAYER("Create player", "C", GameStateEnum.GENERAL),
	NA("Not available", "", GameStateEnum.GENERAL);
	private String description;
	private String shortCut;
	private GameStateEnum status;
	private ActionConfig(String description, String shortCut, GameStateEnum status) {
		this.description = description;
		this.shortCut = shortCut;
		this.status = status;
	}
	
	public static ActionConfig getByShortcut(String shortCut) {
		for(ActionConfig compass:values()) 
			if(compass.shortCut.equalsIgnoreCase(shortCut))
				return compass;
		return NA;
		
	}

	public String getDescription() {
		return description;
	}

	public String getShortCut() {
		return shortCut;
	}

	public GameStateEnum getStatus() {
		return status;
	}

	
	
}
