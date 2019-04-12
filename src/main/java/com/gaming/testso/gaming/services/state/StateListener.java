package com.gaming.testso.gaming.services.state;

import com.gaming.testso.gaming.actions.GamePlayerAction;
import com.gaming.testso.gaming.actions.GameStateAction;
import com.gaming.testso.gaming.context.GameContext;


public interface StateListener {
	
	void setState(GameContext context, GamePlayerAction action);
	void setState(GameContext context, GameStateAction action);

}
