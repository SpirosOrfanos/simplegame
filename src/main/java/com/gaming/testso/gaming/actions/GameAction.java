package com.gaming.testso.gaming.actions;

import com.gaming.testso.gaming.constants.GameStateEnum;

public class GameAction {

	private String action;
	private GameStateEnum status;

	public GameAction(String action, GameStateEnum status) {
		this.action = action;
		this.status = status;
	}

	public String getAction() {
		return action;
	}

	public GameStateEnum getStatus() {
		return status;
	}
}
