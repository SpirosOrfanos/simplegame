package com.gaming.testso.gaming.model;

import com.gaming.testso.gaming.actions.GameAction;
import com.gaming.testso.gaming.actions.GameStateAction;
import com.gaming.testso.gaming.context.GameContext;

public class Game extends GameItem {

	private String UUID;
	public Game(GameContext context, String UUID) {
		this(context);
		this.UUID = UUID;
		
	}
	Game(GameContext context) {
		super();
		context.attach(this);
	}

	@Override
	public void accept(GameAction action) {
		if(action instanceof GameStateAction) {
			draw(action);
			
		}
	}
	

}
