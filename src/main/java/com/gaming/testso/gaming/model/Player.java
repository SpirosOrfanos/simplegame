package com.gaming.testso.gaming.model;

import com.gaming.testso.gaming.actions.GameAction;
import com.gaming.testso.gaming.actions.GamePlayerAction;
import com.gaming.testso.gaming.context.GameContext;

public class Player extends GameItem{
	private String name;
	
	
	public Player(GameContext context, String name) {
		this(context);
		this.name = name;
		
	}
	Player(GameContext context) {
		super();
		context.attach(this);
	}
	public void accept(GameAction action) {
		if(action instanceof GamePlayerAction) {
			draw(action);
		}
	}
}
