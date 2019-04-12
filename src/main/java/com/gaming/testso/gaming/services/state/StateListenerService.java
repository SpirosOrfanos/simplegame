package com.gaming.testso.gaming.services.state;

import com.gaming.testso.gaming.actions.GamePlayerAction;
import com.gaming.testso.gaming.actions.GameStateAction;
import com.gaming.testso.gaming.context.GameContext;

public class StateListenerService implements StateListener{

	@Override
	public void setState(GameContext context, GamePlayerAction action) {
		context.setPlayerState(action.getStatus());
	}

	@Override
	public void setState(GameContext context, GameStateAction action) {
		context.setGameState(action.getStatus());
		
	}

}
