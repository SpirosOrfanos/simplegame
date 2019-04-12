package com.gaming.testso.gaming.model;

import com.gaming.testso.gaming.actions.GameAction;
import com.gaming.testso.gaming.constants.GameStateEnum;
import com.gaming.testso.gaming.context.GameContext;

public abstract class GameItem {

	private static final Board board = new Board();
	
	public abstract void accept(GameAction action);
	void draw(GameAction action) {
		board.accept(action);
	}
}
